package me.mircoporetti.addressline.address.usecase.port;

import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

public interface ParserFactory {
    Parser getParserFor(InlineAddressRequest address);
}
