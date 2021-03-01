package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static me.mircoporetti.addressline.address.usecase.InlineAddressType.*;

public class Addressline implements AddresslineUseCase {

    @Override
    public Address execute(InlineAddressRequest inlineAddressRequest) {
        String inlineAddress = inlineAddressRequest.getAddress();
        Address address = null;

        if(STREET_BEFORE_HOUSE_NUMBER.matches(inlineAddress)){
            Matcher matcher = Pattern.compile("(.+?)(\\d+.+|\\d+)").matcher(inlineAddress);
            if(matcher.find()) {
                String street = matcher.group(1).trim();
                String houseNumber = matcher.group(2);
                address = new Address(street, houseNumber);
            }
        }else if(HOUSE_NUMBER_BEFORE_STREET.matches(inlineAddress)){
            Matcher matcher = Pattern.compile("(\\d+)(.+)").matcher(inlineAddress);
            if(matcher.find()) {
                String houseNumber = matcher.group(1);
                String street = matcher.group(2).replaceAll(",", "").trim();
                address = new Address(street, houseNumber);
            }
        }
        return address;
    }
}
