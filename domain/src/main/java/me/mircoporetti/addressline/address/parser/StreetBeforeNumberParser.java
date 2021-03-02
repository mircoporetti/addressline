package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.port.Parser;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

import java.util.regex.Matcher;

import static me.mircoporetti.addressline.address.parser.InlineAddressRule.*;

public class StreetBeforeNumberParser implements Parser {
    @Override
    public Address parse(InlineAddressRequest address) {
        Matcher matcher = STREET_BEFORE_HOUSE_NUMBER.getMatcherFor(address.getAddress());
        if(matcher.matches())
            return new Address(matcher.group(1).replaceAll(",", "").trim(), matcher.group(2));
        else throw new NotParsableInlineAddressException("The address " + address.getAddress() + " is not parsable with rule STREET_BEFORE_PREFIXED_HOUSE_NUMBER");
    }
}
