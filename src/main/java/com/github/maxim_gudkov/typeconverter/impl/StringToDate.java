package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.impl.config.StringToDateConfig;
import org.jetbrains.annotations.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class StringToDate extends AbstractElementaryConverter {
    private StringToDateConfig stringToDateConfig;

    public StringToDate(StringToDateConfig stringToDateConfig) {
        super(String.class, Date.class);
        Objects.requireNonNull(stringToDateConfig, "stringToDateConfig mus be not null");
        this.stringToDateConfig = stringToDateConfig;
    }

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        String sourceStr = (String) obj;
        for (String mask : stringToDateConfig.getDateMasks()) {
            try {
                return (T) new SimpleDateFormat(mask).parse(sourceStr);
            } catch (ParseException ex) {
                //go to next mask
            }
        }
        throw new ClassCastException("Error convert string " + sourceStr + " to  DATE");
    }

    @Override
    public Object getConverterConfig() {
        return stringToDateConfig;
    }

}
