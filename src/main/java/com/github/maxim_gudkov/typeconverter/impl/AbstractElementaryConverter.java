package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.ElementaryConverter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

abstract class AbstractElementaryConverter implements ElementaryConverter {
    private Class sourceClass;
    private Class resultClass;

    public AbstractElementaryConverter() {
        this(null, null);
    }

    public AbstractElementaryConverter(Class sourceClass, Class resultClass) {
        this.sourceClass = sourceClass;
        this.resultClass = resultClass;
    }

    @Override
    public boolean canConvert(@NotNull Object obj, @NotNull Class resultClass) {
        Objects.requireNonNull(sourceClass, "allowedSourceClass must be not null");
        Objects.requireNonNull(this.resultClass, "allowedResultClass must be not null");
        return sourceClass.isAssignableFrom(obj.getClass()) && this.resultClass.isAssignableFrom(resultClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractElementaryConverter that = (AbstractElementaryConverter) o;
        return getConverterId().equals(that.getConverterId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConverterId());
    }

}
