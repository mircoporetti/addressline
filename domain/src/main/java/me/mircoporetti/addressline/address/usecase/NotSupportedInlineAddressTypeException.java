package me.mircoporetti.addressline.address.usecase;

public class NotSupportedInlineAddressTypeException extends RuntimeException {
    public NotSupportedInlineAddressTypeException(String message) {
        super(message);
    }
}
