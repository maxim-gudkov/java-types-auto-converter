package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.CompositeConverterAware;
import com.github.maxim_gudkov.typeconverter.Converter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class CollectionToArray extends AbstractElementaryConverter implements CompositeConverterAware {

    private Converter compositeConverter;

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        return compositeConverter.convert(((Collection) obj).toArray(), resultClass);
    }

    @Override
    public boolean canConvert(@NotNull Object obj, @NotNull Class resultClass) {
        return obj.getClass().isAssignableFrom(Collection.class) && resultClass.isArray();
    }

    @Override
    public void setCompositeConverter(Converter compositeConverter) {
        this.compositeConverter = compositeConverter;
    }

}
