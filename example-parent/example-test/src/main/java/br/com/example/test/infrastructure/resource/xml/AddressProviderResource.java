package br.com.example.test.infrastructure.resource.xml;

import br.com.example.test.domain.person.PersonBuilder;
import br.com.example.test.domain.person.address.AddressBuilder;
import br.com.example.test.domain.shared.Generator;
import br.com.example.test.domain.shared.Provider;
import br.com.example.test.infrastructure.resource.xml.shared.AbstractXml;

/**
 * Created by igo.tavares on 25/07/15.
 */
public class AddressProviderResource extends AbstractXml<AddressBuilder>
        implements Provider<AddressBuilder>, Generator<AddressBuilder> {

    private static final String PATH = "/person/address/";

    public AddressProviderResource() {
        super(PATH, AddressBuilder.class);
    }
}
