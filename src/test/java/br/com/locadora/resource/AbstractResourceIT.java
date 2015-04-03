package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public abstract class AbstractResourceIT {

    protected WebTarget target;
    protected Client client;

//    @Deployment //(testable = false)
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class).
//                addClasses(Cliente.class, ClienteDto.class, ClienteResource.class);
//    }

    private String getURI() {
        return "http://localhost:8080/app/webresources/";
    }

    protected void createTarget(String path) {
        client = ClientBuilder.newClient();
        target = client.target(URI.create(getURI() + path));
    }

}
