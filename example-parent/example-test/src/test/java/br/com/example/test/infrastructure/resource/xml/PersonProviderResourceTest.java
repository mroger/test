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
public class PersonProviderResourceTest {

    private Provider<PersonBuilder> personProvider;
    private Generator<PersonBuilder> personGenerator;

    public PersonProviderResourceTest() {
        PersonProviderResource personProviderResource = new PersonProviderResource();
        this.personProvider = personProviderResource;
        this.personGenerator = personProviderResource;
    }

    @Test
    public void givenNameIsLuiz_thenItShouldGeneratePerson() {
        PersonBuilder person = new PersonBuilder()
                .withName(PersonConstants.NAME_IS_LUIZ);

        String actual = personGenerator.generate(person);

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>Luiz</name></person>";

        assertEquals(expected, actual);
    }

    @Test
    public void givenNameIsLuizWithAddress_thenItShouldGeneratePersonWithAddress() {
        AddressBuilder address = new AddressBuilder()
                .withNumber(AddressConstants.NUMBER_IS_THIRTEEN);

        PersonBuilder person = new PersonBuilder()
                .withName(PersonConstants.NAME_IS_LUIZ)
                .withAddress(address);

        String actual = personGenerator.generate(person);

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>Luiz</name><address><number>13</number></address></person>";

        assertEquals(expected, actual);
    }

    @Test
    public void givenNameIsLuiz_thenItShouldFindPersonException() {
        PersonBuilder person = personProvider.find(PersonConstants.NAME_IS_LUIZ);

        String expected = "PersonBuilder{name=Luiz, address=null}";

        assertEquals(expected, person.toString());
    }

    @Test
    public void givenNameIsNonExistent_thenItShouldRaiseFileNotFoundException() {
        try {
            personProvider.find(PersonConstants.NAME_IS_NONEXISTENT);
            fail();
        } catch (FileNotFoundException cause) {
            String expected = "File(/person/NONEXISTENT.xml) not found!";

            assertEquals(expected, cause.getMessage());
        }
    }

}
