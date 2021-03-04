package me.mircoporetti.addressline.address.usecase;

import me.mircoporetti.addressline.address.entity.Address;
import me.mircoporetti.addressline.address.usecase.exception.NotValidInlineAddressException;
import me.mircoporetti.addressline.address.usecase.port.Parser;
import me.mircoporetti.addressline.address.usecase.port.ParserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

class AddresslineTest {

    @Mock
    private ParserFactory parserFactory;
    @Mock
    private Parser parser;

    private Addressline underTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        underTest = new Addressline(parserFactory);
    }

   @Test
    void notValidInlineAddress() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("aSingleWordAddress");

        assertThrows(NotValidInlineAddressException.class, () -> underTest.execute(givenAddress));
    }

    @Test
    void parseAnAddress() {
        InlineAddressRequest givenAddress = new InlineAddressRequest("aStreet 1");
        Address expectedAddress = new Address("aStreet", "1");

        doReturn(parser).when(parserFactory).getParserFor(givenAddress);
        doReturn(expectedAddress).when(parser).parse(givenAddress);

        Address result = underTest.execute(givenAddress);

        assertThat(result, is(expectedAddress));
    }
}