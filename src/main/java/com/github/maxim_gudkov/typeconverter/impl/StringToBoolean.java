package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.impl.config.StringToBooleanConfig;

public class StringToBoolean extends AbstractElementaryConverter {
    private StringToBooleanConfig stringToBooleanConfig;

    public StringToBoolean(StringToBooleanConfig stringToBooleanConfig) {
        super(String.class, Boolean.class);
        this.stringToBooleanConfig = stringToBooleanConfig;
    }

    @Override
    public <T> T convert(Object obj, Class<T> resultClass) {
        String booleanString = (String) obj;
        Boolean result;
        if (stringToBooleanConfig.isStrictConverting()) {
            if (stringToBooleanConfig.getTrueString().equalsIgnoreCase(booleanString)) {
                result = true;
            } else if (stringToBooleanConfig.getFalseString().equalsIgnoreCase(booleanString)) {
                result = false;
            } else {
                throw new ClassCastException("Can't convert string " + booleanString + " to boolean ");
            }
        } else {
            result = Boolean.valueOf(booleanString);
        }
        return (T) result;
    }
}
