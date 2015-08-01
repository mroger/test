package br.com.example.test.domain.shared;

/**
 * Created by igo.tavares on 25/07/15.
 */
public interface Generator<E> {

    String generate(E value);

}
