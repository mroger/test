package br.com.example.test.domain.person;

import br.com.example.test.domain.shared.Provider;
import br.com.example.test.infrastructure.resource.xml.PersonProviderResource;

/**
 * Created by igo.tavares on 27/07/15.
 */
public enum PersonFactory {

    LUIZ("Luiz");

    private final String name;

    PersonFactory(String name) {
        this.name = name;
    }

    private final static Provider<PersonBuilder> personProvider;

    static {
       personProvider = new PersonProviderResource();
    }

    public PersonBuilder create() {
        return personProvider.find(this.name);
    }

}
