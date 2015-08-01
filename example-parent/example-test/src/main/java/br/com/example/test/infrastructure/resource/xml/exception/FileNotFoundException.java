package br.com.example.test.infrastructure.resource.xml.exception;

/**
 * Created by igo.tavares on 25/07/15.
 */
public class FileNotFoundException extends RuntimeException {

    private final String name;

    public FileNotFoundException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "File(" + name + ") not found!";
    }
}
