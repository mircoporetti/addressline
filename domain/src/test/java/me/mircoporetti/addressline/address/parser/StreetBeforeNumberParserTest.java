package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.parser.exception.NotParsableInlineAddressException;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StreetBeforeNumberParserTest {

    private StreetBeforeNumberParser underTest;

    @BeforeEach
    void setUp() {
        underTest = new StreetBeforeNumberParser();
    }

    @Test
    void simpleStreetAndOneDigitHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Winterallee 3");
        Address expected = new Address("Winterallee", "3");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void simpleStreetAndTwoDigitHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Musterstrasse 45");
        Address expected = new Address("Musterstrasse", "45");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void simpleStreetAndAlphanumericHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Blaufeldweg 123B");
        Address expected = new Address("Blaufeldweg", "123B");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void twoWordStreetAndHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Am Bächle 23");
        Address expected = new Address("Am Bächle", "23");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void threeWordStreetAndHouseNumberWithSpaceBetween() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Auf der Vogelwiese 23 b");
        Address expected = new Address("Auf der Vogelwiese", "23 b");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void StreetWithSpecialCharAndHouseNumber() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("Calle Aduana, 29");
        Address expected = new Address("Calle Aduana", "29");

        Address result = underTest.parse(givenInlineAddress);
        assertThat(result, is(expected));
    }

    @Test
    void notParsableForParserRule() {
        InlineAddressRequest givenInlineAddress = new InlineAddressRequest("1 wrongAddress");

        assertThrows(NotParsableInlineAddressException.class, () -> underTest.parse(givenInlineAddress));
    }
}