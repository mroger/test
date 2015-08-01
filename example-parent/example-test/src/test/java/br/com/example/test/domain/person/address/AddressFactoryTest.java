package br.com.example.test.domain.person.address;

import br.com.example.domain.person.address.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by igo.tavares on 01/08/15.
 */
public class AddressFactoryTest {

    @Test
    public void shouldCreateHomeAddress() throws Exception {
        AddressBuilder addressBuilder = AddressFactory.HOME.create();

        String expected = "AddressBuilder{number=13}";

        assertEquals(expected, addressBuilder.toString());
    }
}
