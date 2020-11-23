package com.github.maxim_gudkov.typeconverter.impl;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class NumberToNumber extends AbstractElementaryConverter {

    public NumberToNumber() {
        super(Number.class, Number.class);
        init();
    }

    private Set<Class> integerClasses = new HashSet<>();
    private Set<Class> floatClasses = new HashSet<>();
    private Map<Class, Function<Number, ?>> resultClassHandlers = new HashMap<>();

    private void init() {
        resultClassHandlers.put(Integer.class, obj -> obj.intValue());
        resultClassHandlers.put(Long.class, obj -> obj.longValue());
        resultClassHandlers.put(Float.class, obj -> obj.floatValue());
        resultClassHandlers.put(Double.class, obj -> obj.doubleValue());
        resultClassHandlers.put(Byte.class, obj -> obj.byteValue());
        resultClassHandlers.put(Short.class, obj -> obj.shortValue());
        resultClassHandlers.put(BigDecimal.class, this::convertToBigDecimal);
        resultClassHandlers.put(BigInteger.class, this::convertToBigInteger);

        integerClasses.add(Integer.class);
        integerClasses.add(Long.class);
        integerClasses.add(Byte.class);
        integerClasses.add(Short.class);

        floatClasses.add(Float.class);
        floatClasses.add(Double.class);
    }

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        Number sourceObj = (Number) obj;
        Function<Number, ?> resultClassHandler = resultClassHandlers.get(resultClass);
        if (resultClassHandler == null) {
            throw new ClassCastException("Can't convert number to result type " + resultClass);
        }
        return (T) resultClassHandler.apply(sourceObj);
    }

    private BigDecimal convertToBigDecimal(Number num) {
        BigDecimal result;
        if (integerClasses.contains(num.getClass())) {
            result = BigDecimal.valueOf(num.longValue());
        } else if (floatClasses.contains(num.getClass())) {
            result = BigDecimal.valueOf(num.doubleValue());
        } else if (num instanceof BigInteger) {
            result = new BigDecimal((BigInteger) num);
        } else {
            result = BigDecimal.valueOf(num.doubleValue());
        }
        return result;
    }

    private BigInteger convertToBigInteger(Number num) {
        BigInteger result;
        if (integerClasses.contains(num.getClass())) {
            result = BigInteger.valueOf(num.longValue());
        } else if (num instanceof BigDecimal) {
            result = ((BigDecimal) num).toBigInteger();
        } else {
            result = BigDecimal.valueOf(num.doubleValue()).toBigInteger();
        }
        return result;
    }

}
