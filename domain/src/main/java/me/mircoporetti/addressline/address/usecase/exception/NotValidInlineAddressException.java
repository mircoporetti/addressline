package me.mircoporetti.addressline.address.usecase.exception;

public class NotValidInlineAddressException extends RuntimeException{
    public NotValidInlineAddressException(String message) {
        super(message);
    }
}
