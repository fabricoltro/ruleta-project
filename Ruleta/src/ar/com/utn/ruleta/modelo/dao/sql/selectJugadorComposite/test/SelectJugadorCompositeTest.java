package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite.SelectJugadorComposite;
import ar.com.utn.ruleta.modelo.dao.util.SqlConstant;

public class SelectJugadorCompositeTest {
	SelectJugadorComposite selectjdorComp;
	Jugador jugador;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSqlNombreIgual() {
		jugador = new Jugador("juan", null, null);
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_nombre ='juan'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.EQUALS));
		
	}
	
	@Test
	public void testGetSqlNombreLike() {
		jugador = new Jugador("juan", null, null);
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_nombre like '%juan%'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.LIKE));		
	}
	
	@Test
	public void testGetSqlApellidoIgual() {
		jugador = new Jugador(null,"Novoa",null);
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_apellido ='Novoa'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.EQUALS));
		
	}
	
	@Test
	public void testGetSqlApellidoLike() {
		jugador = new Jugador(null,"Novoa",null);
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_apellido like '%Novoa%'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.LIKE));
		
	}
	
	@Test
	public void testGetSqlAliasIgual() {
		jugador = new Jugador(null,null,"Sarasa");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_alias ='Sarasa'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.EQUALS));
		
	}
	
	@Test
	public void testGetSqlAliasLike() {
		jugador = new Jugador(null,null,"Sarasa");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_alias like '%Sarasa%'",
					SelectJugadorComposite.getSql(jugador, SqlConstant.LIKE));
		
	}
	@Test
	public void testGetSqNombreYapellidoEauals() {
		jugador = new Jugador("Gabriel","Casas",null);
		StringBuffer sql  = new StringBuffer("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where ");
					 sql.append("jug_nombre ='Gabriel' and jug_apellido ='Casas'");
					 
		 
		assertEquals(sql.toString(),SelectJugadorComposite.getSql(jugador, SqlConstant.EQUALS));
		
	}

}
