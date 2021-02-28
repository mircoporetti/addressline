package me.mircoporetti.addressline.address.entity;

public class Address {
    private final String street;
    private final String houseNumber;

    public Address(String street, String houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
