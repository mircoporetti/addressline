package me.mircoporetti.addressline.address.usecase;

public class InlineAddressRequest {
    private final String address;

    public InlineAddressRequest(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
