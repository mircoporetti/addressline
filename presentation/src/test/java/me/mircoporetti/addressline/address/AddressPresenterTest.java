package me.mircoporetti.addressline.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.AddresslineUseCase;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

class AddressPresenterTest {
    @Mock
    AddresslineUseCase addresslineUseCase;

    private AddressPresenter underTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        underTest = new AddressPresenter(addresslineUseCase);
    }

    @Test
    void notValidAddressFormat() {
        assertThrows(AddressFormatException.class, () -> underTest.getJsonAddress(new AddressMessageRequest(null)));
    }

    @Test
    void dsf() throws JsonProcessingException {
        AddressMessageRequest givenAddress = new AddressMessageRequest("anAddress");
        doReturn(new Address("aStreet", "anHouseNumber")).when(addresslineUseCase).execute(any());

        String result = underTest.getJsonAddress(givenAddress);

        assertThat(result, is("{\"street\":\"aStreet\",\"houseNumber\":\"anHouseNumber\"}"));

    }
}