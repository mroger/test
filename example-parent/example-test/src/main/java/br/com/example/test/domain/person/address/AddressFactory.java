package br.com.example.test.domain.person.address;

import br.com.example.test.domain.person.PersonBuilder;
import br.com.example.test.domain.shared.Provider;
import br.com.example.test.infrastructure.resource.xml.AddressProviderResource;
import br.com.example.test.infrastructure.resource.xml.PersonProviderResource;

/**
 * Created by igo.tavares on 27/07/15.
 */
public enum AddressFactory {

    HOME("home");

    private final String name;

    AddressFactory(String name) {
        this.name = name;
    }

    private final static Provider<AddressBuilder> addressProvider;

    static {
        addressProvider = new AddressProviderResource();
    }

    public AddressBuilder create() {
        return addressProvider.find(this.name);
    }

}
