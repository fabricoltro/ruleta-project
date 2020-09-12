package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.OpcionGrupo;
import ar.com.utn.ruleta.modelo.OpcionGrupoFrom19to36;
import ar.com.utn.ruleta.modelo.OpcionGrupoFrom1to18;
import ar.com.utn.ruleta.modelo.OpcionGrupoImpar;
import ar.com.utn.ruleta.modelo.OpcionGrupoNegro;
import ar.com.utn.ruleta.modelo.OpcionGrupoPar;
import ar.com.utn.ruleta.modelo.OpcionGrupoPrimerDocena;
import ar.com.utn.ruleta.modelo.OpcionGrupoRojo;
import ar.com.utn.ruleta.modelo.OpcionGrupoSegundaDocena;
import ar.com.utn.ruleta.modelo.OpcionGrupoTercerDocena;

public class OpcionGrupoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstanceNegro() {
		//TODO Fabri, repeti esto para cada uno de los grupos
		//aca se verifica que el objeto que esta devolviendo es de tipo OpcionGrupooNegro
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.NEGRO) 
				instanceof  OpcionGrupoNegro);
	}
	@Test
	public void testGetInstanceRojo() {
		//TODO Fabri, repeti esto para cada uno de los grupos
		//aca se verifica que el objeto que esta devolviendo es de tipo OpcionGrupooNegro
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.ROJO) 
				instanceof  OpcionGrupoRojo);
	}
	@Test
	public void testGetInstancePar() {
		//TODO Fabri, repeti esto para cada uno de los grupos
		//aca se verifica que el objeto que esta devolviendo es de tipo OpcionGrupooNegro
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.PAR) 
				instanceof  OpcionGrupoPar);
	}
	@Test
	public void testGetInstanceImpar() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.IMPAR) 
				instanceof  OpcionGrupoImpar);
	}
	@Test
	public void testGetInstancePrimeraDocena() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.PRIMEADOCENA) 
				instanceof  OpcionGrupoPrimerDocena);
	}
	@Test
	public void testGetInstanceSegundaDocena() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.SEGUNDADOCENA) 
				instanceof  OpcionGrupoSegundaDocena);
	}
	@Test
	public void testGetInstanceTercerDocena() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.TERCERADOCENA) 
				instanceof  OpcionGrupoTercerDocena);
	}
	@Test
	public void testGetInstanceFrom1to18() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.FROM1TO18) 
				instanceof  OpcionGrupoFrom1to18);
	}
	@Test
	public void testGetInstanceFrom19to36() {
		
		assertTrue(OpcionGrupo.getInstance(OpcionGrupo.FROM19TO36) 
				instanceof  OpcionGrupoFrom19to36);
	}
}
