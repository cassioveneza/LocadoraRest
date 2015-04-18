package br.com.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractService <T> {

    @PersistenceContext
    protected EntityManager em;
    
    public void persist(T t) {
        em.persist(t);
    }
    
    public T merge(T t) {
        return em.merge(t);
    }

}
