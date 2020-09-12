package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.SelectJugadorStrategy;
import ar.com.utn.ruleta.modelo.dao.util.SqlConstant;

public class SelectJugadorStrategyTest {
	SelectJugadorStrategy sjStgy;
	Jugador jugador=null;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstanceJugadorNull() {
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}

	@Test
	public void testGetInstanceJugadorVacio() {
		jugador = new Jugador();
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}
	
	@Test
	public void testGetInstanceJugadorApellido() {
		jugador = new Jugador();
		jugador.setApellido("Quintas");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_apellido ='Quintas'",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}

	@Test
	public void testGetInstanceJugadorNombre() {
		jugador = new Jugador();
		jugador.setNombre("Lucas");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_nombre ='Lucas'",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}

	@Test
	public void testGetInstanceJugadorAlias() {
		jugador = new Jugador();
		jugador.setAlias("Kingtas");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_alias ='Kingtas'",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}
	
	@Test
	public void testGetInstanceJugadorAliasyApellido() {
		jugador = new Jugador();
		jugador.setAlias("Kingtas");
		jugador.setApellido("Quintas");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_apellido ='Quintas' and jug_alias ='Kingtas'",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.EQUALS).getSql());		
	}
	
	@Test
	public void testGetInstanceJugadorAliasyApellidoLike() {
		jugador = new Jugador();
		jugador.setAlias("Kingtas");
		jugador.setApellido("Quintas");
		assertEquals("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where jug_apellido like '%Quintas%' and jug_alias like '%Kingtas%'",
					SelectJugadorStrategy.getInstance(jugador, SqlConstant.LIKE).getSql());		
	}

}
