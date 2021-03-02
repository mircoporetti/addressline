package me.mircoporetti.addressline.address.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum InlineAddressRule {

    STREET_BEFORE_HOUSE_NUMBER(Pattern.compile("(.+?)(\\d+.+|\\d+)")),
    HOUSE_NUMBER_BEFORE_STREET(Pattern.compile("(\\d+)(.+)")),
    STREET_BEFORE_PREFIXED_HOUSE_NUMBER(Pattern.compile("(.+?)(No \\d+|no \\d+)"));

    private final Pattern regex;

    InlineAddressRule(Pattern s) {
        this.regex = s;
    }

    public Boolean matches(String inlineAddress){
        return regex.matcher(inlineAddress).matches();
    }

    public Matcher getMatcherFor(String text){
        return regex.matcher(text);
    }

}