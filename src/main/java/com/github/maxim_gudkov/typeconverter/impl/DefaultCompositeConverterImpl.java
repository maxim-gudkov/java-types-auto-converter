package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.CompositeConverter;
import com.github.maxim_gudkov.typeconverter.CompositeConverterAware;
import com.github.maxim_gudkov.typeconverter.ElementaryConverter;
import com.github.maxim_gudkov.typeconverter.impl.config.DateToStringConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.NumberToBooleanConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.StringToBooleanConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.StringToDateConfig;

import java.util.Arrays;
import java.util.List;

public final class DefaultCompositeConverterImpl implements CompositeConverter {
    private List<ElementaryConverter> converters;

    public DefaultCompositeConverterImpl() {
        List<ElementaryConverter> convertersList = Arrays.asList(
                new StringToNumber(),
                new StringToEnum(),
                new StringToBoolean(new StringToBooleanConfig()),
                new StringToDate(new StringToDateConfig()),
                new DateToString(new DateToStringConfig()),
                new NumberToNumber(),
                new NumberToBoolean(new NumberToBooleanConfig()),
                new ArrayToArray(),
                new CollectionToArray(),
                new ObjectToString(),
                new ObjectToObject()
        );
        putElementaryConverters(convertersList);
    }

    @Override
    public void putElementaryConverters(List<ElementaryConverter> converters) {
        this.converters = converters;
        converters.forEach(
                converter -> {
                    if (converter instanceof CompositeConverterAware)
                        ((CompositeConverterAware) converter).setCompositeConverter(this);
                });
    }

    @Override
    public List<ElementaryConverter> getElementaryConverters() {
        return converters;
    }


}

