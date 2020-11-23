package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.CompositeConverterAware;
import com.github.maxim_gudkov.typeconverter.Converter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;

public class ArrayToArray extends AbstractElementaryConverter implements CompositeConverterAware {

    private Converter compositeConverter;

    @Override
    public <T> T convert(@NotNull Object array, @NotNull Class<T> resultClass) {
        int arrayLength = Array.getLength(array);
        Class<?> arrayElementClass = resultClass.isArray() ? resultClass.getComponentType() : null;

        Object resultArray = Array.newInstance(arrayElementClass, arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            Object resultElement = compositeConverter.convert(Array.get(array, i), arrayElementClass);
            Array.set(resultArray, i, resultElement);
        }
        return (T) resultArray;
    }


    @Override
    public boolean canConvert(@NotNull Object obj, @NotNull Class resultClass) {
        return obj.getClass().isArray() && resultClass.isArray();
    }

    @Override
    public void setCompositeConverter(Converter compositeConverter) {
        this.compositeConverter = compositeConverter;
    }
}
