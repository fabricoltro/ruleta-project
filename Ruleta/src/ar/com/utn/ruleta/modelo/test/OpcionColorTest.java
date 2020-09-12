package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.OpcionGrupo;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class OpcionColorTest {
	OpcionGrupo opcColor;
	@Before
	public void setUp() throws Exception {
//		opcColor = new OpcionGrupo(100, 
//				new Integer(GruposDeNumeros.NEGRO));
	}
	@After
	public void tearDown() throws Exception {
		opcColor = null;
	}

	@Test
	public void testValidar_true() throws RuletaException {
		assertTrue(opcColor.validar(new Numero(2)));
	}

	@Test
	public void testValidar_false() throws RuletaException {
		assertFalse(opcColor.validar(new Numero(7)));
	}
	@Test
	public void testValor_error()  {
//		try {
//			opcColor.setValor(new Integer(GruposDeNumeros.TERCERDOCENA));
//			//si llega a seguir de largo tiene que dar error
//			assertTrue(false);
//		} catch (RuletaException e) {
//			assertEquals("El valor no corresponde ni a Negro ni a Rojo",
//					e.getMessage());			
//		}
	}
	@Test
	public void testCobrar() {
		assertEquals(200, opcColor.cobrar());
	}

}
