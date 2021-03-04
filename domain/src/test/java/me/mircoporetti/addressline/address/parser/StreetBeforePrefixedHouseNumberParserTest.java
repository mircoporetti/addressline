package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.parser.exception.NotParsableInlineAddressException;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class StreetBeforePrefixedHouseNumberParserTest {

    private StreetBeforePrefixedHouseNumberParser underTest;

    @BeforeEach
    void setUp() {
        underTest = new StreetBeforePrefixedHouseNumberParser();
    }


    @Test
    void simpleStreetAndAlphanumericHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Calle 39 No 1540");
        Address expected = new Address("Calle 39", "No 1540");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void notParsableForParserRule() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("wrongAddress 1");

        assertThrows(NotParsableInlineAddressException.class, () -> underTest.parse(givenInlineAddress));
    }
}