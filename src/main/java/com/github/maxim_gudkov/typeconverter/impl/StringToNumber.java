package com.github.maxim_gudkov.typeconverter.impl;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class StringToNumber extends AbstractElementaryConverter {

    public StringToNumber() {
        super(String.class, Number.class);
        init();
    }

    private Map<Class, Function<String, ?>> resultClassHandlers = new HashMap<>();

    private void init() {
        resultClassHandlers.put(Integer.class, str -> Integer.valueOf(str));
        resultClassHandlers.put(Long.class, str -> Long.valueOf(str));
        resultClassHandlers.put(Float.class, str -> Float.valueOf(str));
        resultClassHandlers.put(Double.class, str -> Double.valueOf(str));
        resultClassHandlers.put(Byte.class, str -> Byte.valueOf(str));
        resultClassHandlers.put(Short.class, str -> Short.valueOf(str));
        resultClassHandlers.put(BigDecimal.class, BigDecimal::new);
        resultClassHandlers.put(BigInteger.class, BigInteger::new);
    }

    @Override
    public <T> T convert(@NotNull Object obj, @NotNull Class<T> resultClass) {
        String sourceStr = (String) obj;
        Function<String, ?> resultClassHandler = resultClassHandlers.get(resultClass);
        if (resultClassHandler == null) {
            throw new ClassCastException("Can't convert string to result number type " + resultClass);
        }
        return resultClass.cast(resultClassHandler.apply(sourceStr));
    }
}
