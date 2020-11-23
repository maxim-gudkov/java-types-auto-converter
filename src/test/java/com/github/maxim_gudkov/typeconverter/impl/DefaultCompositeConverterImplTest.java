package com.github.maxim_gudkov.typeconverter.impl;


import com.github.maxim_gudkov.typeconverter.TypeAutoConverter;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DefaultCompositeConverterImplTest {

    @Test
    public void convertNull() {
        Assert.assertNull("Null converting", TypeAutoConverter.convert(null, String.class));
    }

    @Test
    public void convertStringToNumber() {
        Assert.assertEquals("String to Short", Short.valueOf((short) 42), TypeAutoConverter.convert("42", Short.class));
        Assert.assertEquals("String to Long", Long.valueOf(42L), TypeAutoConverter.convert("42", Long.class));
        Assert.assertEquals("String to Byte", Byte.valueOf((byte) 42), TypeAutoConverter.convert("42", Byte.class));
        Assert.assertEquals("String to Int", Integer.valueOf(42), TypeAutoConverter.convert("42", Integer.class));

        Assert.assertEquals("String to Float", Float.valueOf(42.42f), TypeAutoConverter.convert("42.42", Float.class));
        Assert.assertEquals("String to Double", Double.valueOf(42.42), TypeAutoConverter.convert("42.42", Double.class));
        Assert.assertEquals("String to BigInteger", BigInteger.valueOf(42), TypeAutoConverter.convert("42", BigInteger.class));
        Assert.assertEquals("String to BigDecimal", BigDecimal.valueOf(42.42), TypeAutoConverter.convert("42.42", BigDecimal.class));
    }

    @Test
    public void convertStringToBoolean() {
        Assert.assertTrue("True string to Boolean", TypeAutoConverter.convert("TruE", Boolean.class));
        Assert.assertFalse("False string to Boolean", TypeAutoConverter.convert("falSE", Boolean.class));
        Assert.assertThrows("Wrong String to Boolean converting", ClassCastException.class, () -> TypeAutoConverter.convert("1111", Boolean.class));
    }

    @Test
    public void convertNumberToBoolean() {
        Assert.assertTrue("True float number to Boolean", TypeAutoConverter.convert(Float.valueOf(1), Boolean.class));
        Assert.assertTrue("True short number to Boolean", TypeAutoConverter.convert(Short.valueOf((short)1), Boolean.class));
        Assert.assertTrue("True long number to Boolean", TypeAutoConverter.convert(Long.valueOf(1L), Boolean.class));
        Assert.assertFalse("False long number to Boolean", TypeAutoConverter.convert(Long.valueOf(0L), Boolean.class));
        Assert.assertThrows("Wrong Number to Boolean converting", ClassCastException.class, () -> TypeAutoConverter.convert(5, Boolean.class));
    }


    @Test
    public void convertArrays() {
        Assert.assertArrayEquals("String arrays to Integer array", new Integer[]{1, 2, 3},
                TypeAutoConverter.convertToArray(new String[]{"1", "2", "3"}, Integer.class));
    }


}
