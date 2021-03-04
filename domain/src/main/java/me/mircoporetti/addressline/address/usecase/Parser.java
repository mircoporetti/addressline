package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

public interface Parser {
    Address parse(InlineAddressRequest address);
}
