package com.github.maxim_gudkov.typeconverter.impl;

import com.github.maxim_gudkov.typeconverter.impl.config.NumberToBooleanConfig;

public class NumberToBoolean extends AbstractElementaryConverter {
    private NumberToBooleanConfig numberToBooleanConfig;

    public NumberToBoolean(NumberToBooleanConfig numberToBooleanConfig) {
        super(Number.class, Boolean.class);
        this.numberToBooleanConfig = numberToBooleanConfig;
    }

    @Override
    public <T> T convert(Object obj, Class<T> resultClass) {
        Long booleanNumber = ((Number) obj).longValue();
        Boolean result;
        if (numberToBooleanConfig.getTrueNumber().longValue() == booleanNumber) {
            result = true;
        } else if (numberToBooleanConfig.getFalseNumber().longValue() == booleanNumber) {
            result = false;
        } else {
            throw new ClassCastException("Can't convert number " + booleanNumber + " to boolean ");
        }
        return (T) result;
    }
}
