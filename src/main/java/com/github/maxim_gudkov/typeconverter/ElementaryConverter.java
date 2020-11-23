package com.github.maxim_gudkov.typeconverter;

import org.jetbrains.annotations.NotNull;


public interface ElementaryConverter extends Converter {

    default Object getConverterConfig() {
        return null;
    }

    default String getConverterId() {
        return this.getClass().getName();
    }

    boolean canConvert(Object obj, Class resultClass);

    @Override
    <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass);

}
