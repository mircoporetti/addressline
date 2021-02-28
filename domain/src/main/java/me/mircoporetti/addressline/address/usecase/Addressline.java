package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;

public class Addressline implements AddresslineUseCase {

    @Override
    public Address execute(InlineAddressRequest inlineAddressRequest) {
        String[] addressParts = inlineAddressRequest.getAddress().split(" ");
        return new Address(addressParts[0], addressParts[1]);
    }
}
