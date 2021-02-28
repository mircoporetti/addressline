package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;

public interface AddresslineUseCase {
    Address execute(InlineAddressRequest inlineAddressRequest);
}
