package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.port.Parser;
import me.mircoporetti.addressline.address.usecase.port.ParserFactory;

public class Addressline implements AddresslineUseCase {

    private final ParserFactory parserFactory;

    public Addressline(ParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    @Override
    public Address execute(InlineAddressRequest inlineAddressRequest) {
        if (inlineAddressRequest.couldBeAValidAddress()) {
            Parser parser = parserFactory.getParserFor(inlineAddressRequest);
            return parser.parse(inlineAddressRequest);
        } else {
            throw new NotValidInlineAddressException("The address: " + inlineAddressRequest.getAddress() + " can't be an address");
        }
    }
}
