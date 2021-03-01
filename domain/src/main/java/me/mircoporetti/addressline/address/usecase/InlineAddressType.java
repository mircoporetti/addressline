package me.mircoporetti.addressline.address.usecase;

import java.util.regex.Pattern;

public enum InlineAddressType {

    STREET_BEFORE_HOUSE_NUMBER(Pattern.compile("(.+?)(\\d+.+|\\d+)")),
    HOUSE_NUMBER_BEFORE_STREET(Pattern.compile("(\\d+)(.+)"));

    private final Pattern regex;

    InlineAddressType(Pattern s) {
        this.regex = s;
    }

    public Boolean matches(String text){
        return regex.matcher(text).find();
    }

}