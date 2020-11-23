package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.CompositeConverter;
import com.github.maxim_gudkov.typeconverter.CompositeConverterAware;
import com.github.maxim_gudkov.typeconverter.ElementaryConverter;
import com.github.maxim_gudkov.typeconverter.impl.config.DateToStringConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.NumberToBooleanConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.StringToBooleanConfig;
import com.github.maxim_gudkov.typeconverter.impl.config.StringToDateConfig;

import java.util.*;
import java.util.stream.Collectors;

public final class DefaultCompositeConverterImpl implements CompositeConverter {
    private List<ElementaryConverter> converters;
    private Map<String, ElementaryConverter> convertersMap;

    public DefaultCompositeConverterImpl() {
        List<ElementaryConverter> converters = Arrays.asList(
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
        putElementaryConverters(new LinkedHashSet(converters));
    }

    @Override
    public void putElementaryConverters(LinkedHashSet<ElementaryConverter> convertersSet) {
        converters = new ArrayList<>(convertersSet);
        convertersMap = converters.stream()
                .peek(c -> {
                    if (c instanceof CompositeConverterAware)
                        ((CompositeConverterAware) c).setCompositeConverter(this);
                })
                .collect(Collectors.toMap(ElementaryConverter::getConverterId, item -> item));
    }

    @Override
    public List<ElementaryConverter> getElementaryConverters() {
        return converters;
    }

    @Override
    public ElementaryConverter getElementaryConverter(String converterId) {
        return convertersMap.get(converterId);
    }

}

