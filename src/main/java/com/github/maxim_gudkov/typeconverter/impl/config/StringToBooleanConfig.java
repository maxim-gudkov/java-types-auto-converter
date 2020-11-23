package com.github.maxim_gudkov.typeconverter.impl.config;

public class StringToBooleanConfig {
    private String falseString = "FALSE";
    private String trueString = "TRUE";
    private boolean strictConverting = true;

    public String getFalseString() {
        return falseString;
    }

    public void setFalseString(String falseString) {
        this.falseString = falseString;
    }

    public String getTrueString() {
        return trueString;
    }

    public void setTrueString(String trueString) {
        this.trueString = trueString;
    }

    public boolean isStrictConverting() {
        return strictConverting;
    }

    public void setStrictConverting(boolean strictConverting) {
        this.strictConverting = strictConverting;
    }
}
