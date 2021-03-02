package me.mircoporetti.addressline.address.usecase.port;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

public interface Parser {
    Address parse(InlineAddressRequest address);
}
