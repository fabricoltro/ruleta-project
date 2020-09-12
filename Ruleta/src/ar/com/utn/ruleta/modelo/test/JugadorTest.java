package ar.com.utn.ruleta.modelo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.Opcion4Numeros;
import ar.com.utn.ruleta.modelo.OpcionGrupoRojo;
import ar.com.utn.ruleta.modelo.ruleta;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class JugadorTest {
	Jugador 		jugador	;
	Apuesta 		apuesta	;
	List<Opcion> 	opciones;
	ruleta 			ruleta	;

	@Before
	public void setUp() throws Exception {
		jugador = new Jugador(1, "Gabriel", "Casas", "gcasas", 1000);
		apuesta = new Apuesta();
		//agrego una apuesta
		jugador.addApuesta(apuesta);
		
		apuesta.addOpcion(new Opcion1Numero(100, new Numero(1) ));
		apuesta.addOpcion(new Opcion2Numeros(100, 1,2));
		apuesta.addOpcion(new Opcion4Numeros(1,1,2,4,5,100));
		apuesta.addOpcion(new OpcionGrupoRojo(100));
		
		
				
	}

	@After
	public void tearDown() throws Exception {
		jugador =null;
		apuesta =null;
		
	}

	@Test
	public void testMontoDelJugadorDespuesDeTirarJugar_NO_GANA() throws RuletaException {
		apuesta.setNumeroGanador(new Numero(6));
		assertEquals(600, jugador.getMonto());
	}

	@Test
	public void testMontoDelJugadorDespuesDeTirarJugar_GANA_OPCION4NUM() throws RuletaException {
		apuesta.setNumeroGanador(new Numero(5));
		assertEquals(1700, jugador.getMonto());
	}
	@Test
	public void testMontoDelJugadorDespuesDeTirarJugar_GANA_OPCION4NUM_y_2NUM() throws RuletaException {
		apuesta.setNumeroGanador(new Numero(2));
		assertEquals(3300, jugador.getMonto());
	}

	@Test
	public void testMontoDelJugadorAntesDeTirarLaBola() {
		assertEquals(600, jugador.getMonto());
	}
	

}
