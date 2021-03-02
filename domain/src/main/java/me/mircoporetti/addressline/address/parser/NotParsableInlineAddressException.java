package me.mircoporetti.addressline.address.parser;

public class NotParsableInlineAddressException extends RuntimeException {
    public NotParsableInlineAddressException(String message) {
        super(message);
    }
}
