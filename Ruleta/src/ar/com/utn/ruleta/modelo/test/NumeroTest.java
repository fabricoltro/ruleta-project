package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class NumeroTest {
    Numero num;
    
	@Before
	public void setUp() throws Exception {
		num= new Numero(7);
	}

	@After
	public void tearDown() throws Exception {
		num=null;
	}

	@Test
	public void testHashCode() {
		assertEquals(7, num.hashCode());
	}

	@Test
	public void testNumero() {
		num = new Numero();
		assertEquals(0, num.getValor());
	}

	@Test
	public void testNumeroInt() throws RuletaException {
		num = new Numero(10);
		assertEquals(10, num.getValor());
	}
	@Test
	public void testNumeroInt_error(){
		try {
			num = new Numero(57);
		} catch (RuletaException e) {
			//lo correcto es que se produzca la excepcion
			assertEquals("El numero no esta en el rango 0 - 36", e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testEqualsObject_ok() throws RuletaException {
		Numero num2 = new Numero(7);
		assertTrue(num.equals(num2));
	}
	@Test
	public void testEqualsObject_fallido() throws RuletaException {
		Numero num2 = new Numero(8);
		assertFalse(num.equals(num2));
	}
	

	@Test
	public void testToString() {
		assertEquals("valor=7\n", num.toString());
	}

	@Test
	public void testIsRojo_ok() {
		assertTrue(num.isRojo());
	}
	
	@Test
	public void testIsRojo_fallido() throws RuletaException {
		num.setValor(2);
		assertFalse(num.isRojo());
	}
	
	@Test
	public void testIsNegro_ok() throws RuletaException {
		num.setValor(2);
		assertTrue(num.isNegro());
	}
	@Test
	public void testIsNegro_fallido() {
			assertFalse(num.isNegro());
	}
	
	@Test
	public void testIsRoj0_fallido_con0() throws RuletaException {
		num.setValor(0);
		assertFalse(num.isRojo());
	}
	
	@Test
	public void testIsNegro_fallido_con0() throws RuletaException {
		num.setValor(0);
		assertFalse(num.isNegro());
	}
	
	@Test
	public void testIsPrimerColumna_exitosa() throws RuletaException {		
		assertTrue(num.isPrimeraColumna());
	}
	@Test
	public void testIsPrimerColumna_fallida() throws RuletaException {
		num.setValor(20);
		assertFalse(num.isPrimeraColumna());
	}
	
	@Test
	public void testIsSegundaColumna_exitosa() throws RuletaException {	
		num.setValor(20);
		assertTrue(num.isSegundaColumna());
	}
	@Test
	public void testIsSegundaColumna_fallida() throws RuletaException {
		assertFalse(num.isSegundaColumna());
	}
	@Test
	public void testIsTercerColumna_exitosa() throws RuletaException {	
		num.setValor(36);
		assertTrue(num.isTercerColumna());
	}
	@Test
	public void testIsTercerColumna_fallida() throws RuletaException {
		assertFalse(num.isTercerColumna());
	}
	
	@Test
	public void testIsFrom1To18_exitosa() throws RuletaException {	
		assertTrue(num.isFrom1To18());
	}
	
	@Test
	public void testIsFrom1To18_fallida() throws RuletaException {
		num.setValor(19);
		assertFalse(num.isFrom1To18());
	}

	@Test
	public void testIsFrom19To36_exitosa() throws RuletaException {
		num.setValor(19);
		assertTrue(num.isFrom19To36());
	}
	
	@Test
	public void testIsFrom19To36_fallida() throws RuletaException {
		num.setValor(14);
		assertFalse(num.isFrom19To36());
	}

}




