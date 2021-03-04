package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.parser.exception.NotParsableInlineAddressException;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import me.mircoporetti.addressline.address.usecase.Parser;

import java.util.regex.Matcher;

import static me.mircoporetti.addressline.address.parser.InlineAddressRule.STREET_BEFORE_PREFIXED_HOUSE_NUMBER;

public class StreetBeforePrefixedHouseNumberParser implements Parser {

    private final InlineAddressRule addressRule = STREET_BEFORE_PREFIXED_HOUSE_NUMBER;

    @Override
    public Address parse(InlineAddressRequest address) {
        Matcher matcher = addressRule.getMatcherFor(address.getAddress());
        if(matcher.matches())
            return new Address(matcher.group(1), matcher.group(2).trim());
        else throw new NotParsableInlineAddressException("The address " + address.getAddress() + " is not parsable with rule " + addressRule.name());
    }
}
