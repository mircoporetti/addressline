package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.parser.exception.NotParsableInlineAddressException;
import me.mircoporetti.addressline.address.usecase.Parser;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

import java.util.regex.Matcher;

import static me.mircoporetti.addressline.address.parser.InlineAddressRule.HOUSE_NUMBER_BEFORE_STREET;

public class NumberBeforeStreetParser implements Parser {

    private final InlineAddressRule addressRule = HOUSE_NUMBER_BEFORE_STREET;

    @Override
    public Address parse(InlineAddressRequest address) {
        Matcher matcher = addressRule.getMatcherFor(address.getAddress());
        if(matcher.matches())
            return new Address(matcher.group(2).replaceAll(",","").trim(), matcher.group(1));
        else throw new NotParsableInlineAddressException("The address " + address.getAddress() + " is not parsable with rule " + addressRule.name());
    }
}
