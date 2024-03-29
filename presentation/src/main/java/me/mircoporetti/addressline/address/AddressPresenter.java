package me.mircoporetti.addressline.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.AddresslineUseCase;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;

/*
    The presenter interacts with the domain to execute a particular use case.
    This kind of approach allows you to consider the infrastructure layers as plugins
    of the application business logic. The main goal is to leave the domain independent.
 */
public class AddressPresenter {
    private final AddresslineUseCase addresslineUseCase;
    private final ObjectMapper objectMapper;

    public AddressPresenter(AddresslineUseCase addresslineUseCase, ObjectMapper objectMapper) {
        this.addresslineUseCase = addresslineUseCase;
        this.objectMapper = objectMapper;
    }

    public String parseAddress(AddressMessageRequest addressMessageRequest) throws JsonProcessingException {
        if(addressMessageRequest.validate()){
            Address address = addresslineUseCase.execute(new InlineAddressRequest(addressMessageRequest.getAddress()));
            return objectMapper.writeValueAsString(address);
        }else{
            throw new AddressFormatException("The input " + addressMessageRequest.getAddress() + " is not in a valid format");
        }
    }
}
