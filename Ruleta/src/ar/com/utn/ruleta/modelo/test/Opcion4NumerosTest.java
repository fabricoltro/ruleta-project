package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion;
import ar.com.utn.ruleta.modelo.Opcion4Numeros;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion4NumerosTest {
	List<Numero> cuatroNumeList ;
	List<Numero> cuatroNumeList2 ;
	List<Numero> cuatroNumeList3 ;
	
	List<Numero> cuatroNumeFallida ;
	List<Numero> cuatroNumeFallida2 ;
	List<Numero> cuatroNumeFallida3 ;
	Opcion4Numeros opcion4Numeros ;
	@Before
	public void setUp() throws Exception {
		cuatroNumeList = new ArrayList<Numero>();
		cuatroNumeList.add(new Numero(1));
		cuatroNumeList.add(new Numero(2));
		cuatroNumeList.add(new Numero(4));
		cuatroNumeList.add(new Numero(5));
		
		cuatroNumeList2 = new ArrayList<Numero>();
		cuatroNumeList2.add(new Numero(14));
		cuatroNumeList2.add(new Numero(15));
		cuatroNumeList2.add(new Numero(17));
		cuatroNumeList2.add(new Numero(18));

		cuatroNumeList3 = new ArrayList<Numero>();
		cuatroNumeList3.add(new Numero(31));
		cuatroNumeList3.add(new Numero(32));
		cuatroNumeList3.add(new Numero(34));
		cuatroNumeList3.add(new Numero(35));

		
		cuatroNumeFallida = new ArrayList<Numero>();
		cuatroNumeFallida.add(new Numero(1));
		cuatroNumeFallida.add(new Numero(2));
		cuatroNumeFallida.add(new Numero(3));
		cuatroNumeFallida.add(new Numero(4));
		
		cuatroNumeFallida2 = new ArrayList<Numero>();
		cuatroNumeFallida2.add(new Numero(3));
		cuatroNumeFallida2.add(new Numero(8));
		cuatroNumeFallida2.add(new Numero(9));
		cuatroNumeFallida2.add(new Numero(12));

		cuatroNumeFallida3 = new ArrayList<Numero>();
		cuatroNumeFallida3.add(new Numero(10));
		cuatroNumeFallida3.add(new Numero(11));
		cuatroNumeFallida3.add(new Numero(16));
		cuatroNumeFallida3.add(new Numero(17));
		
		
		opcion4Numeros = new Opcion4Numeros(1, cuatroNumeList,100);
	}

	@After
	public void tearDown() throws Exception {
		cuatroNumeList=null;
		opcion4Numeros=null;
	}
	@Test
	public void testSetNumero_fallida2() {
		try {
			opcion4Numeros.setNumeros(cuatroNumeFallida2);
			assertTrue(false); //ai viene por aca pintalo de rojo
		} catch (RuletaException e) {
			assertEquals("Lita de 4 numeros erronea", e.getMessage());
		}

	}
	@Test
	public void testSetNumero_fallida3() {
		try {
			opcion4Numeros.setNumeros(cuatroNumeFallida3);
			assertTrue(false); //ai viene por aca pintalo de rojo
		} catch (RuletaException e) {
			assertEquals("Lita de 4 numeros erronea", e.getMessage());
		}

	}
	@Test
	public void testSetNumero_fallida() {
		try {
			opcion4Numeros.setNumeros(cuatroNumeFallida);
			assertTrue(false); //ai viene por aca pintalo de rojo
		} catch (RuletaException e) {
			assertEquals("Lita de 4 numeros erronea", e.getMessage());
		}

	}
	
	@Test
	public void testValidar_ok1() throws RuletaException {
		assertTrue(opcion4Numeros.validar(new Numero(2)));
	}
	@Test
	public void testValidar_ok2() throws RuletaException {
		assertTrue(opcion4Numeros.validar(new Numero(5)));
	}
	@Test
	public void testValidar_Fallido() throws RuletaException {
		assertFalse(opcion4Numeros.validar(new Numero(10)));
	}
	@Test
	public void testValidar_error() {
		try {
			assertFalse(opcion4Numeros.validar(new Numero(50)));
			assertTrue(false);
		} catch (RuletaException e) {
			assertEquals("El numero no esta en el rango 0 - 36", e.getMessage());
		}
	}

	@Test
	public void testCobrar() {
		assertEquals(900, opcion4Numeros.cobrar());
	}

	@Test
	public void testSetNumero_ok() {
		
		try {
			opcion4Numeros.setNumeros(cuatroNumeList);
			assertTrue(true);  // lo pino de verde
		} catch (RuletaException e) {
			assertTrue(false); //lo pinto de rojo
		}
		
	}

	@Test
	public void testSetNumero_ok2() {
		
		try {
			opcion4Numeros.setNumeros(cuatroNumeList2);
			assertTrue(true);
		} catch (RuletaException e) {
			assertTrue(false);
		}
		
	}

	@Test
	public void testSetNumero_ok3() {
		
		try {
			opcion4Numeros.setNumeros(cuatroNumeList3);
			assertTrue(true);
		} catch (RuletaException e) {
			assertTrue(false);
		}
		
	}

	
	
}










