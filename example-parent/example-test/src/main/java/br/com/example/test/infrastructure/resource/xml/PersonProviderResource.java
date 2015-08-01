package br.com.example.test.infrastructure.resource.xml;

import br.com.example.test.domain.person.PersonBuilder;
import br.com.example.test.domain.shared.Generator;
import br.com.example.test.domain.shared.Provider;
import br.com.example.test.infrastructure.resource.xml.shared.AbstractXml;

/**
 * Created by igo.tavares on 22/07/15.
 */
public class PersonProviderResource extends AbstractXml<PersonBuilder>
        implements Provider<PersonBuilder>, Generator<PersonBuilder> {


    private static final String PATH = "/person/";

    public PersonProviderResource() {
        super(PATH, PersonBuilder.class);
    }

}
