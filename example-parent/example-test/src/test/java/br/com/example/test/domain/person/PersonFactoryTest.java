package br.com.example.test.domain.person;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by igo.tavares on 27/07/15.
 */
public class PersonFactoryTest {

    @Test
    public void shouldCreateLuizPerson() throws Exception {
        PersonBuilder personBuilder = PersonFactory.LUIZ.create();

        String expected = "PersonBuilder{name=Luiz, address=null}";

        assertEquals(expected, personBuilder.toString());
    }

}
