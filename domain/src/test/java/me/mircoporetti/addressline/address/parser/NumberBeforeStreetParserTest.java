package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NumberBeforeStreetParserTest {

    private NumberBeforeStreetParser underTest;

    @BeforeEach
    void setUp() {
        underTest = new NumberBeforeStreetParser();
    }


    @Test
    void numberBeforeStreet() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("200 Broadway Av");
        Address expected = new Address("Broadway Av", "200");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void numberBeforeStreetWithSpecialChar() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("4, rue de la revolution");
        Address expected = new Address("rue de la revolution", "4");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }
}