package br.com.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
public abstract class AbstractResource {

    @PersistenceContext
    protected EntityManager em;

}
