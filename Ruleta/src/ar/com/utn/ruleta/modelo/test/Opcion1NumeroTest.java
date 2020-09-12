package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion1NumeroTest {
	Opcion1Numero opcion1;
	
	@Before
	public void setUp() throws Exception {
		opcion1 = new Opcion1Numero(100, new Numero(10));		
	}
	@After
	public void tearDown() throws Exception {
		opcion1 = null;
	}

	@Test
	public void testValidar_Verdadero() throws RuletaException {		
		assertTrue( opcion1.validar(new Numero(10)));
	}

	@Test
	public void testValidar_Falso() throws RuletaException {		
		assertFalse( opcion1.validar(new Numero(11)));
	}

	@Test
	public void testOpcion1Numero_getSaldo() throws RuletaException {
		assertEquals(100, opcion1.getSaldo());
	}

	@Test
	public void testSetNumero() throws RuletaException {
		//mod by gcasas
		opcion1.setNumero(new Numero(20));
		assertEquals(new Numero(20), opcion1.getNumero());
	}
	@Test
	public void testCobrar_verdadero(){
		assertEquals(3600, opcion1.cobrar());
	}

}

	
	
	
	
	
	
