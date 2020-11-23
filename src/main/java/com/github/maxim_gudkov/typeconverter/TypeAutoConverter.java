package com.github.maxim_gudkov.typeconverter;

import com.github.maxim_gudkov.typeconverter.impl.DefaultCompositeConverterImpl;

import java.lang.reflect.Array;

/**
 * Utility class for using implementation of types converter
 */
public final class TypeAutoConverter {
    private static CompositeConverter compositeConverter = new DefaultCompositeConverterImpl();

    /**
     * Get implementation of types converter
     */
    public static CompositeConverter getCompositeConverter() {
        return compositeConverter;
    }

    /**
     * Set implementation of types converter
     */
    public static void setCompositeConverter(CompositeConverter compositeConverter) {
        TypeAutoConverter.compositeConverter = compositeConverter;
    }

    /**
     * Convert types method
     */
    public static <T> T convert(Object obj, Class<T> resultClass) {
        return compositeConverter.convert(obj, resultClass);
    }

    public static <T> T[] convertToArray(Object obj, Class<T> resultArrayElementClass) {
        T[] x = (T[]) Array.newInstance(resultArrayElementClass, 0);
        return (T[]) compositeConverter.convert(obj, x.getClass());
    }

}
