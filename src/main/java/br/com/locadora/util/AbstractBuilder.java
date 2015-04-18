package br.com.locadora.util;

public abstract class AbstractBuilder<T, B extends AbstractBuilder> {

    protected T entity;

    protected AbstractBuilder(T entity) {
        this.entity = entity;
    }

    protected void validate() {
    }

    public T build() {
        validate();
        return entity;
    }

}
