package com.github.maxim_gudkov.typeconverter.impl.config;

public class NumberToBooleanConfig {
    private Number falseNumber = 0;
    private Number trueNumber = 1;

    public Number getFalseNumber() {
        return falseNumber;
    }

    public void setFalseNumber(Number falseNumber) {
        this.falseNumber = falseNumber;
    }

    public Number getTrueNumber() {
        return trueNumber;
    }

    public void setTrueNumber(Number trueNumber) {
        this.trueNumber = trueNumber;
    }
}
