package com.github.maxim_gudkov.typeconverter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public interface CompositeConverter extends Converter {

    void putElementaryConverters(List<ElementaryConverter> converters);

    List<ElementaryConverter> getElementaryConverters();

    default ElementaryConverter getElementaryConverter(String converterId) {
        Objects.requireNonNull(converterId, "converterId must be not null");
        return getElementaryConverters().stream()
                .filter(converter -> converter.getConverterId().equals(converterId))
                .findFirst()
                .orElse(null);
    }

    default <T> T convert(Object obj, @NotNull Class<T> resultClass) {
        Objects.requireNonNull(resultClass, "Result class must be not null");
        if (obj == null)
            return null;
        if (resultClass.equals(obj.getClass()))
            return resultClass.cast(obj);
        return getElementaryConverters().stream()
                .filter(converter -> converter.canConvert(obj, resultClass))
                .findFirst()
                .orElseThrow(() -> new ClassCastException("Can't find converter for result " + resultClass))
                .convert(obj, resultClass);
    }


}
