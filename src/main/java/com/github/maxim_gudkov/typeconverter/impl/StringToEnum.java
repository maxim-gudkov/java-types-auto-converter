package com.github.maxim_gudkov.typeconverter.impl;


import org.jetbrains.annotations.NotNull;

public class StringToEnum extends AbstractElementaryConverter {

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        return (T) Enum.valueOf((Class<? extends Enum>) resultClass, (String) obj);
    }

    @Override
    public boolean canConvert(@NotNull Object obj, @NotNull Class resultClass) {
        return obj.getClass().isEnum() && resultClass == String.class;
    }

}
