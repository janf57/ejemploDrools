package com.atSistemas.antifraude.motor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import com.atSistemas.antifraude.motor.service.domain.Access;
import com.atSistemas.antifraude.motor.service.domain.Client;
import com.atSistemas.antifraude.motor.service.domain.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	
        super( testName );
        /*
    	Map <String, String> trama = new HashMap<>();
    	trama.put("login","1234");
    	trama.put("pwd","1111");
    	trama.put("ip","1.1.1.1");
    	Request request = new Request(Request.Type.ACCESS, trama);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	String sRequest;
    	try {
			sRequest = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	trama = new HashMap<>();
    	trama.put("login","1234");
    	trama.put("ccc","1234 1234 1234 1234");
    	trama.put("ip","1.2.3.4");
    	request = new Request(Request.Type.IP, trama);
    	
    	try {
			sRequest = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            //Cargamos la base de reglas
        	KieSession kieSession = leerReglas();
 
            //Obtenemos los empleados
            Collection<Client> clientes = buscarClients();
 
            for (Client cliente : clientes) {
            	kieSession.insert(cliente);
            }
 
            //Disparamos las reglas de Drools
            kieSession.fireAllRules();
 
            for (Client cliente : clientes) {
                System.out.println("Cliente: " + cliente);
            }
            Access acceso = null;
            acceso = new Access("1.1.1.1", "1234", "1111");
            kieSession.insert(acceso);
            System.out.println("primer login");
            kieSession.fireAllRules();
            acceso = new Access("1.1.1.1", "1234", "1111");
            kieSession.insert(acceso);
            System.out.println("segundo login");
            kieSession.fireAllRules();
            acceso = new Access("1.1.1.1", "1234", "1111");
            kieSession.insert(acceso);
            System.out.println("tercer login");
            kieSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }*/
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    private static Collection<Client> buscarClients() {
        ArrayList<Client> clientes = new ArrayList<Client>();
 
        //Creamos algunos clientes para el ejemplo
        Client client1 = new Client("1234", "1234");
        Client client2 = new Client("3456", "3456");
        Client client3 = new Client("5678", "5678");
 
        clientes.add(client1);
        clientes.add(client2);
        clientes.add(client3);
 
        return clientes;
    }  
    private KieSession leerReglas() throws Exception {
        //Leemos el archivo de reglas (DRL)
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        //Parseamos y compilamos las reglas en un único paso
        kbuilder.add(ResourceFactory.newClassPathResource("antiFraude_Accesos_v1.0.drl"), ResourceType.DRL);
 
        // Verificamos el builder para ver si hubo errores
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
            throw new RuntimeException(
                "No se pudo compilar el archivo de reglas.");
        }
        Collection<KiePackage> pkgs = kbuilder.getKnowledgePackages();
        kbase.addPackages( pkgs );

        KieSession ksession = kbase.newKieSession();

        return ksession;
    }
}
