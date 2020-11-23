package com.github.maxim_gudkov.typeconverter.impl;

import org.jetbrains.annotations.NotNull;

public class ObjectToString extends AbstractElementaryConverter {

    public ObjectToString() {
        super(Object.class, String.class);
    }

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        return (T) obj.toString();
    }

}
