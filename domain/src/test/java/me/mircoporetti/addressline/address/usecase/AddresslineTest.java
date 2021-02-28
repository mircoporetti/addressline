package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AddresslineTest {

    private Addressline underTest;

    @BeforeEach
    void setUp() {
        underTest = new Addressline();
    }

    @Test
    void streetBeforeAnHouseNumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Winterallee 3");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Winterallee", "3");
        assertThat(result, is(expectedAddress));
    }

    @Test
    void streetBeforeABiggerHouseNumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Musterstrasse 45");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Musterstrasse", "45");
        assertThat(result, is(expectedAddress));
    }

    @Test
    void streetBeforeABnAlphanumericHouseNumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Blaufeldweg 123B");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Blaufeldweg", "123B");
        assertThat(result, is(expectedAddress));
    }
}