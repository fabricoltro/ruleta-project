package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion2NumerosTest {
	Opcion2Numeros opcion2num;
	@Before
	public void setUp() throws Exception {
		List<Numero> numeros = new ArrayList<Numero>();
		numeros.add(new Numero(1));
		numeros.add(new Numero(2));
		opcion2num = new Opcion2Numeros(100, numeros);		
	}

	@After
	public void tearDown() throws Exception {
		opcion2num = null;
	}

	@Test
	public void testValidar_verdadero() throws RuletaException {
		assertTrue(opcion2num.validar(new Numero(1)));
	}
	@Test
	public void testValidar_falso() throws RuletaException {
		assertFalse(opcion2num.validar(new Numero(3)));
	}
	@Test
	public void testOpcion2Numeros() throws RuletaException {
		//comparo el saldo
		assertEquals(100, opcion2num.getSaldo());
		
		List<Numero> numeros = new ArrayList<Numero>();
		numeros.add(new Numero(1));
		numeros.add(new Numero(2));
		//comparo el valor		
		assertEquals(numeros, opcion2num.getNumeros());		
	}

	@Test
	public void testSetValorListOfNumero() throws RuletaException {
		List<Numero> numNuevo = new ArrayList<Numero>();
		numNuevo.add(new Numero(4));
		numNuevo.add(new Numero(5));
		opcion2num.setNumeros(numNuevo);;
		
		assertEquals(numNuevo, opcion2num.getNumeros());	
		
	}
	
	@Test
	public void testCobrar_Verdadero(){
		assertEquals(1800, opcion2num.cobrar());
	}

	

}
