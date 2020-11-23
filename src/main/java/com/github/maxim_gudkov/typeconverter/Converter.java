package com.github.maxim_gudkov.typeconverter;
import org.jetbrains.annotations.NotNull;


public interface Converter {

    <T> T convert(Object obj, @NotNull Class<T> resultClass);

}
