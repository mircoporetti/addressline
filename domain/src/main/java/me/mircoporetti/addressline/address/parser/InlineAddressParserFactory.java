package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.parser.exception.NotSupportedInlineAddressTypeException;
import me.mircoporetti.addressline.address.usecase.Parser;
import me.mircoporetti.addressline.address.usecase.ParserFactory;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

import static me.mircoporetti.addressline.address.parser.InlineAddressRule.*;

public class InlineAddressParserFactory implements ParserFactory {

    @Override
    public Parser getParserFor(InlineAddressRequest address) {
        String inlineAddress = address.getAddress();
        if(HOUSE_NUMBER_BEFORE_STREET.matches(inlineAddress)){
            return new NumberBeforeStreetParser();
        }else if(STREET_BEFORE_PREFIXED_HOUSE_NUMBER.matches(inlineAddress)){
            return new StreetBeforePrefixedHouseNumberParser();
        }else if(STREET_BEFORE_HOUSE_NUMBER.matches(inlineAddress)){
            return new StreetBeforeNumberParser();
        }else{
            throw new NotSupportedInlineAddressTypeException("Inline address " + inlineAddress + " format is not supported");
        }
    }
}
