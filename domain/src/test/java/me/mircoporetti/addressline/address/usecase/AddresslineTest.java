package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class AddresslineTest {

    private Addressline underTest;

    @BeforeEach
    void setUp() {
        underTest = new Addressline();
    }

    @Test
    void streetBeforeANumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Winterallee 3");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Winterallee", "3");
        assertThat(result, is(expectedAddress));


    }
}