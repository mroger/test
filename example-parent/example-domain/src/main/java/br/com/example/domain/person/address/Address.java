package br.com.example.domain.person.address;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by igo.tavares on 22/07/15.
 */
@XmlRootElement
public class Address implements Serializable {

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
