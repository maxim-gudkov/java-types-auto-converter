package com.github.maxim_gudkov.typeconverter.impl.config;

import java.util.Arrays;
import java.util.List;

public class StringToDateConfig {
    private List<String> dateMasks = Arrays.asList("yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd");

    public List<String> getDateMasks() {
        return dateMasks;
    }

    public void setDateMasks(List<String> dateMasks) {
        this.dateMasks = dateMasks;
    }
}
