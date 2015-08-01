package br.com.example.test.domain.person;

import br.com.example.domain.person.Person;
import br.com.example.test.domain.person.address.AddressBuilder;
import br.com.example.test.domain.person.address.AddressFactory;
import br.com.example.test.domain.shared.Builder;
import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by igo.tavares on 22/07/15.
 */
@XmlRootElement(name = "person")
public class PersonBuilder implements Builder<Person> {

    private String name;
    private AddressBuilder address;

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withHomeAddress() {
        return withAddress(AddressFactory.HOME.create());
    }

    public PersonBuilder withAddress(AddressBuilder address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        Person person = new Person();
        person.setName(name);
        if (address != null) {
            person.setAddress(address.build());
        }
        return person;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("address", address)
                .toString();
    }
}
