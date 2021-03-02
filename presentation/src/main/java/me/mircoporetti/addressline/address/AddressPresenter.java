package me.mircoporetti.addressline.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.AddresslineUseCase;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

public class AddressPresenter {
    private final AddresslineUseCase addresslineUseCase;

    public AddressPresenter(AddresslineUseCase addresslineUseCase) {
        this.addresslineUseCase = addresslineUseCase;
    }

    public String parseAddress(AddressMessageRequest addressMessageRequest) throws JsonProcessingException {
        if(addressMessageRequest.validate()){
            Address address = addresslineUseCase.execute(new InlineAddressRequest(addressMessageRequest.getAddress()));
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(address);
        }else{
            throw new AddressFormatException("The input " + addressMessageRequest.getAddress() + " is not a valid format");
        }
    }
}
