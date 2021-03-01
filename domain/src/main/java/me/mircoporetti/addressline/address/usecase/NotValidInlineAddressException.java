package me.mircoporetti.addressline.address.usecase;

public class NotValidInlineAddressException extends RuntimeException{
    public NotValidInlineAddressException(String message) {
        super(message);
    }
}
