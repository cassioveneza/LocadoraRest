package br.com.locadora.resource;

import java.net.URI;

public class Api {

    private final static String URL_BASE = "http://localhost:8080/app/webresources";

    public static class Clientes {

        public final static String SELF = URL_BASE + "/clientes";
        public final static String SELF_ID = SELF + "/{id}";

    }

}
