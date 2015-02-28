package br.com.locadora.resource;

import br.com.locadora.dto.FilmeDto;
import br.com.locadora.model.Filme;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FilmeResourceTest {

    public FilmeResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test(enabled = false)
    public void testCreate() throws Exception {
        FilmeDto dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmeResource instance = (FilmeResource) container.getContext().lookup("java:global/classes/FilmeResource");
        FilmeDto expResult = null;
        FilmeDto result = instance.create(dto);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test(enabled = false)
    public void testUpdate() throws Exception {
        System.out.println("update");
        Long id = null;
        FilmeDto dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmeResource instance = (FilmeResource) container.getContext().lookup("java:global/classes/FilmeResource");
        FilmeDto expResult = null;
        FilmeDto result = instance.update(id, dto);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test(enabled = false)
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmeResource instance = (FilmeResource) container.getContext().lookup("java:global/classes/FilmeResource");
        List<Filme> expResult = null;
        List<Filme> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test(enabled = false)
    public void testRemove() throws Exception {
        System.out.println("remove");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmeResource instance = (FilmeResource) container.getContext().lookup("java:global/classes/FilmeResource");
        instance.remove(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test(enabled = false)
    public void testFindNotFound() throws Exception {
        System.out.println("find");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmeResource instance = (FilmeResource) container.getContext().lookup("java:global/classes/FilmeResource");
        Filme expResult = null;
        Filme result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
