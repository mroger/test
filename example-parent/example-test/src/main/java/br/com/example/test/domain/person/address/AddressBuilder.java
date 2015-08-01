package br.com.example.test.domain.person.address;

import br.com.example.domain.person.address.Address;
import com.google.common.base.Objects;
import com.sun.istack.internal.Builder;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by igo.tavares on 22/07/15.
 */
@XmlRootElement(name = "address")
public class AddressBuilder implements Builder<Address> {

    private Integer number;

    public AddressBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    @Override
    public Address build() {
        Address address = new Address();
        address.setNumber(number);
        return address;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("number", number)
                .toString();
    }
}
