package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.usecase.port.Parser;
import me.mircoporetti.addressline.address.usecase.port.ParserFactory;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import me.mircoporetti.addressline.address.usecase.NotSupportedInlineAddressTypeException;

import static me.mircoporetti.addressline.address.parser.InlineAddressRule.*;

public class InlineAddressParserFactory implements ParserFactory {

    @Override
    public Parser getParserFor(InlineAddressRequest address) {
        if(HOUSE_NUMBER_BEFORE_STREET.matches(address.getAddress())){
            return new NumberBeforeStreetParser();
        }else if(STREET_BEFORE_HOUSE_NUMBER.matches(address.getAddress())){
            return new StreetBeforeNumberParser();
        }else{
            throw new NotSupportedInlineAddressTypeException("Inline address " + address.getAddress() + " format is not supported");
        }
    }
}
