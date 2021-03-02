package me.mircoporetti.addressline.address;

public class AddressMessageRequest {
    private final String address;

    public AddressMessageRequest(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public boolean validate() {
        return address != null;
    }
}
