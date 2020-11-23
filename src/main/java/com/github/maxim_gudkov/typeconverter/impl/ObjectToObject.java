package com.github.maxim_gudkov.typeconverter.impl;

import org.jetbrains.annotations.NotNull;


public class ObjectToObject extends AbstractElementaryConverter {

    public ObjectToObject() {
        super(Object.class, Object.class);
    }

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        return (T) obj;
    }

    @Override
    public boolean canConvert(@NotNull Object obj, @NotNull Class resultClass) {
        return resultClass.isAssignableFrom(obj.getClass());
    }

}
