package br.com.example.test.infrastructure.resource.xml.shared;

import br.com.example.test.infrastructure.resource.xml.exception.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Created by igo.tavares on 22/07/15.
 */
public class AbstractXml<E> {

    private static final String EXT = ".xml";
    private final JAXBContext jc;
    private final String path;

    public AbstractXml(String path, Class<?>... classesToBeBound) {
        this.path = path;
        jc = createJAXBContext(classesToBeBound);
    }

    private JAXBContext createJAXBContext(Class<?>[] classesToBeBound) {
        try {
            return JAXBContext.newInstance(classesToBeBound);
        } catch (JAXBException cause) {
           throw new RuntimeException(cause);
        }
    }

    public E find(String name) {
        Unmarshaller unmarshaller = createUnmarshaller();
        return (E) unmarshal(name, unmarshaller);
    }

    private Object unmarshal(String name, Unmarshaller unmarshaller) {
        try {
            return unmarshaller.unmarshal(createFile(name));
        } catch (JAXBException cause) {
            throw new RuntimeException(cause);
        }
    }

    private Unmarshaller createUnmarshaller() {
        try {
            return jc.createUnmarshaller();
        } catch (JAXBException cause) {
            throw new RuntimeException(cause);
        }
    }

    private InputStream createFile(String name) {
        InputStream inputStream = getClass().getResourceAsStream(path + name + EXT);
        if (inputStream == null) {
            throw new FileNotFoundException(path + name + EXT);
        }
        return inputStream;
    }

    public String generate(E value) {
        return marshaller(value);
    }

    private String marshaller(E value) {
        Marshaller marshaller = createMarshaller();
        StringWriter writer = new StringWriter();
        try {
            marshaller.marshal(value, writer);
        } catch (JAXBException cause) {
            throw new RuntimeException(cause);
        }
        return writer.toString();
    }

    public Marshaller createMarshaller() {
        try {
            return jc.createMarshaller();
        } catch (JAXBException cause) {
            throw new RuntimeException(cause);
        }
    }

}
