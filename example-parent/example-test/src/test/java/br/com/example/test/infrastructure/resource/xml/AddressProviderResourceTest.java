package br.com.example.test.infrastructure.resource.xml;

import br.com.example.test.ExampleTestConstants.*;
import br.com.example.test.domain.person.PersonBuilder;
import br.com.example.test.domain.person.address.AddressBuilder;
import br.com.example.test.domain.shared.Generator;
import br.com.example.test.domain.shared.Provider;
import br.com.example.test.infrastructure.resource.xml.exception.FileNotFoundException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by igo.tavares on 25/07/15.
 */
public class AddressProviderResourceTest {

    private Provider<AddressBuilder> addressProvider;
    private Generator<AddressBuilder> addressGenerator;

    public AddressProviderResourceTest() {
        AddressProviderResource addressProviderResource = new AddressProviderResource();
        this.addressProvider = addressProviderResource;
        this.addressGenerator = addressProviderResource;
    }

    @Test
    public void givenNumberIsThirteen_thenItShouldGenereteAddress() {
        AddressBuilder address = new AddressBuilder()
                .withNumber(AddressConstants.NUMBER_IS_THIRTEEN);

        String actual = addressGenerator.generate(address);

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><address><number>13</number></address>";

        assertEquals(expected, actual);
    }

    @Test
    public void givenNameIsHome_thenItShouldFindAddress() {
        AddressBuilder address = addressProvider.find(AddressConstants.TYPE_IS_HOME);

        String expected = "AddressBuilder{number=13}";

        assertEquals(expected, address.toString());
    }

    @Test
    public void givenNameIsNonExistent_thenItShouldRaiseFileNotFoundExecption() {
        try {
            addressProvider.find(AddressConstants.TYPE_IS_NONEXISTENT);
            fail();
        } catch (FileNotFoundException cause) {
            String expected = "File(/person/address/NONEXISTENT.xml) not found!";

            assertEquals(expected, cause.getMessage());
        }
    }

}
