package me.mircoporetti.addressline.address.parser;

import me.mircoporetti.addressline.address.usecase.port.Parser;
import me.mircoporetti.addressline.address.usecase.InlineAddressRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class InlineAddressParserFactoryTest {

    private InlineAddressParserFactory underTest;

    @BeforeEach
    void setUp() {
        underTest = new InlineAddressParserFactory();
    }

    @Test
    void streetBeforeHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Winterallee 3");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }

    @Test
    void streetBeforeTwoDigitsHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Musterstrasse 45");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }

    @Test
    void streetBeforeAlphanumericHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Blaufeldweg 123B");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }

    @Test
    void twoWordsStreetBeforeHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Am Bächle 23");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }

    @Test
    void threeWordsStreetBeforeComplexHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Auf der Vogelwiese 23 b");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }

    @Test
    void HouseNumberBeforeStreet_returnedANumberBeforeStreetParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("200 Broadway Av");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(NumberBeforeStreetParser.class)));
    }

    @Test
    void HouseNumberBeforeStreetWithSpecialChar_returnedANumberBeforeStreetParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("4, rue de la revolution");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(NumberBeforeStreetParser.class)));
    }

    @Test
    void StreetWithSpecialCharBeforeHouseNumber_returnedAStreetBeforeNumberParser() {
        InlineAddressRequest inlineAddressRequest = new InlineAddressRequest("Calle Aduana, 29");

        Parser result = underTest.getParserFor(inlineAddressRequest);

        assertThat(result, is(instanceOf(StreetBeforeNumberParser.class)));
    }
}