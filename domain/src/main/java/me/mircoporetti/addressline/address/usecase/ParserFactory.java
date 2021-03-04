package me.mircoporetti.addressline.address.usecase;

public interface ParserFactory {
    Parser getParserFor(InlineAddressRequest address);
}
