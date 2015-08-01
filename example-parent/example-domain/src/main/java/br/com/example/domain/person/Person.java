package br.com.example.domain.person;

import br.com.example.domain.person.address.Address;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by igo.tavares on 22/07/15.
 */
@XmlRootElement
public class Person implements Serializable {

    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
