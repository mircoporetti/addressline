package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addressline implements AddresslineUseCase {

    @Override
    public Address execute(InlineAddressRequest inlineAddressRequest) {

        Pattern pattern = Pattern.compile("(.+?)(\\d+.+|\\d+)");
        Matcher matcher = pattern.matcher(inlineAddressRequest.getAddress());

        if(matcher.find()){
            String street = matcher.group(1).trim();
            String houseNumber = matcher.group(2);
            return new Address(street, houseNumber);
        }

        else return null;
    }
}
