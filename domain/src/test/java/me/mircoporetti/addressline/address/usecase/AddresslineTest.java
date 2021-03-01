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

    @Test
    void twoWordStreetBeforeANumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Am Bächle 23");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Am Bächle", "23");
        assertThat(result, is(expectedAddress));
    }

    @Test
    void threeWordStreetBeforeAnAlphanumericNumber() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("Auf der Vogelwiese 23 b");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("Auf der Vogelwiese", "23 b");
        assertThat(result, is(expectedAddress));
    }

    @Test
    void numberBeforeStreet() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("4, rue de la revolution");
        Address result = underTest.execute(givenAddress);

        Address expectedAddress = new Address("rue de la revolution", "4");
        assertThat(result, is(expectedAddress));
    }
}