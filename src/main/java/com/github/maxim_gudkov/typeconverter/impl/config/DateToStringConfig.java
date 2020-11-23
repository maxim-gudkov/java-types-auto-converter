package com.github.maxim_gudkov.typeconverter.impl.config;

public class DateToStringConfig {
    private String dateMask = "yyyy-MM-dd'T'HH:mm:ss";

    public String getDateMask() {
        return dateMask;
    }

    public void setDateMask(String dateMask) {
        this.dateMask = dateMask;
    }
}
