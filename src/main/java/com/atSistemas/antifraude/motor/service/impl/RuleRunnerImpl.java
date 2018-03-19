package com.atSistemas.antifraude.motor.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.atSistemas.antifraude.motor.service.RuleRunner;
import com.atSistemas.antifraude.motor.service.domain.Access;
import com.atSistemas.antifraude.motor.service.domain.Alert;
import com.atSistemas.antifraude.motor.service.domain.Client;
import com.atSistemas.antifraude.motor.service.domain.CuentaNegra;
import com.atSistemas.antifraude.motor.service.domain.IpNegra;
import com.atSistemas.antifraude.motor.service.domain.Operation;
import com.atSistemas.antifraude.motor.service.domain.Result;
import com.atSistemas.antifraude.motor.service.domain.Threshold;

/**
 * Implementacion de {@link com.atSistemas.antifraude.motor.service.RuleRunner}
 *
 * @author Jose Antonio Navarro janavarro.fuentes@atsistemas.com
 */
@Service
public class RuleRunnerImpl implements RuleRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleRunnerImpl.class);
	private KieSession kieSession = null;

	public RuleRunnerImpl() {
        try {
            //Cargamos la base de reglas
        	kieSession = leerReglas();
 
            populateWorkingMemory();
        } catch (Throwable t) {
        	LOGGER.error("*****************************************");
        	LOGGER.error("*******EL ENTORNO NO SE HA CREADO********");
        	LOGGER.error("*****************************************");
        	LOGGER.error(t.getMessage());
        }
	}
	
    private void populateWorkingMemory() {
    	//Obtenemos los clientes
        Collection<Client> clientes = buscarClients();

        for (Client cliente : clientes) {
        	kieSession.insert(cliente);
        }
        //Obtenemos las ipsNegras
        Collection<IpNegra> ipsNegras = buscarIpsNegras();

        for (IpNegra ipNegra : ipsNegras) {
        	kieSession.insert(ipNegra);
        }
        //Obtenemos las cuentasNegras
        Collection<CuentaNegra> cuentasNegras = buscarCuentasNegras();

        for (CuentaNegra cuentaNegra : cuentasNegras) {
        	kieSession.insert(cuentaNegra);
        }  
        
        //Obtenemos los umbrales
        Collection<Threshold> thresholds = buscarThresholds();

        for (Threshold threshold : thresholds) {
        	kieSession.insert(threshold);
        }          
		
	}

	private KieSession leerReglas() throws Exception {
    	LOGGER.info("leerReglas [IN]");
        //Leemos el archivo de reglas (DRL)
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        //Parseamos y compilamos las reglas en un único paso
        kbuilder.add(ResourceFactory.newClassPathResource("antiFraude_Accesos_v1.0.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("antiFraude_Operaciones_v1.0.drl"), ResourceType.DRL);
 
        // Verificamos el builder para ver si hubo errores
        if (kbuilder.hasErrors()) {
            LOGGER.error(kbuilder.getErrors().toString());
            throw new RuntimeException(
                "No se pudo compilar el archivo de reglas.");
        }
        Collection<KiePackage> pkgs = kbuilder.getKnowledgePackages();
        kbase.addPackages( pkgs );

        KieSession ksession = kbase.newKieSession();
        ksession.setGlobal("logger", LOGGER);
    	LOGGER.info("leerReglas [OUT]");
        return ksession;
    }
    
    private Collection<Client> buscarClients() {
        ArrayList<Client> clientes = new ArrayList<>();
 
        //Creamos algunos clientes para el ejemplo
        Client client1 = new Client("1234", "1234");
        Client client2 = new Client("3456", "3456");
        Client client3 = new Client("5678", "5678");
 
        clientes.add(client1);
        clientes.add(client2);
        clientes.add(client3);
 
        return clientes;
    }
    private Collection<IpNegra> buscarIpsNegras() {
        ArrayList<IpNegra> ipsNegras = new ArrayList<IpNegra>();
 
        //Carga de ipsNegras
        IpNegra ipNegra1 = new IpNegra("1.2.3.4");
        IpNegra ipNegra2 = new IpNegra("3.4.5.6");
        IpNegra ipNegra3 = new IpNegra("5.6.7.8");
 
        ipsNegras.add(ipNegra1);
        ipsNegras.add(ipNegra2);
        ipsNegras.add(ipNegra3);
 
        return ipsNegras;
    }
    private Collection<CuentaNegra> buscarCuentasNegras() {
        ArrayList<CuentaNegra> cuentasNegras = new ArrayList<>();
 
        //Carga de cuentas negras
        CuentaNegra cuentaNegra1 = new CuentaNegra("1234 1234 1234 1234");
        CuentaNegra cuentaNegra2 = new CuentaNegra("3456 3456 3456 3456");
        CuentaNegra cuentaNegra3 = new CuentaNegra("5678 5678 5678 5678");
 
        cuentasNegras.add(cuentaNegra1);
        cuentasNegras.add(cuentaNegra2);
        cuentasNegras.add(cuentaNegra3);
 
        return cuentasNegras;
    }
    private Collection<Threshold> buscarThresholds() {
        ArrayList<Threshold> thresholds = new ArrayList<>();
 
        //Carga de umbrales
        Threshold umbral1 = new Threshold(Threshold.Type.MAX_LOGINS_INCORRECTOS, 2);
        Threshold umbral2 = new Threshold(Threshold.Type.TIME_LOGINS_INCORRECTOS, 5);
        Threshold umbral3 = new Threshold(Threshold.Type.TIME_OPERACIONES_BAJAS, 5);
        Threshold umbral4 = new Threshold(Threshold.Type.CANTIDAD_OPERACION_BAJA, 1000);
 
        thresholds.add(umbral1);
        thresholds.add(umbral2);
        thresholds.add(umbral3);
        thresholds.add(umbral4);
 
        return thresholds;
    }
    
    
	@Override
	public Result launchOperation(Operation oper) {

    	LOGGER.info("launchOperation [IN]");
        kieSession.insert(oper);
        kieSession.fireAllRules();
        Collection<Object> myfacts = (Collection<Object>) kieSession.getObjects( new ClassObjectFilter(Alert.class) );
    	LOGGER.info("launchOperation [OUT]");
        return oper.getResult();
	}

	@Override
	public Result launchAccess(Access access) {
    	LOGGER.info("launchAccess [IN]");
        kieSession.insert(access);
        kieSession.fireAllRules();
        Collection<Object> myfacts = (Collection<Object>) kieSession.getObjects( new ClassObjectFilter(Alert.class) );
    	LOGGER.info("launchAccess [OUT]");
		return access.getResult();
	}  
}
