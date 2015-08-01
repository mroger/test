package br.com.example.test.domain.shared;

/**
 * Created by igo.tavares on 25/07/15.
 */
public interface Provider<E> {

    E find(String name);

}
