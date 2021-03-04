package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.exception.NotValidInlineAddressException;

/*
    This is the use case of the application. It usually executes the application specific logic and it orchestrates
    the entities. In this case the only task of the use case is to create an Address domain model (through a factory).
    For example, if in the future there is the need to extract the parsing logic and to put it into another component/service,
    it will be easy to call it using a port interface implemented by an infrastructure adapter.
 */
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
