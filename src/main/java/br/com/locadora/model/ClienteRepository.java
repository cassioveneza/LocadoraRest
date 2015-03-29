package br.com.locadora.model;

import br.com.locadora.util.AbstractRepository;

public class ClienteRepository extends AbstractRepository <Cliente> {

    public ClienteRepository() {
        super(Cliente.class);
    }

}
