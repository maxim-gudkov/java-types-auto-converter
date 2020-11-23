package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.impl.config.DateToStringConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString extends AbstractElementaryConverter {

    private DateToStringConfig config;

    public DateToString(DateToStringConfig config) {
        super(Date.class, String.class);
        this.config = config;
    }

    @Override
    public <T> T convert(Object obj, Class<T> resultClass) {
        return (T) new SimpleDateFormat(config.getDateMask()).format((Date) obj);
    }

    @Override
    public Object getConverterConfig() {
        return config;
    }
}
