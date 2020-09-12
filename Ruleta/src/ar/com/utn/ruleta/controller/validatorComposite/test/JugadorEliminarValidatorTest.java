package ar.com.utn.ruleta.controller.validatorComposite.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.utn.ruleta.controller.validatorComposite.JugadorCRUDValidator;
import ar.com.utn.ruleta.dao.test.Opcion1NumeroDAOTest;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class JugadorEliminarValidatorTest {
	static Connection con;
	Statement stat;
	Jugador jugador;
	
	

	@Test
	public void testGetErroresCodigoMayorQueCero_error() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(0, "Casas_test", "gcasas_test","alias_test");
		
		assertEquals("El codigo debe ser mayor que 0(cero)\n", 
					JugadorCRUDValidator.getErroresAlEliminar(jugador));
	}
	@Test
	public void testGetErroresCodigoMayorQueCero_sinError() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(3, "Casas_test", "gcasas_test","alias_test");
		
		assertEquals("",JugadorCRUDValidator.getErroresAlEliminar(jugador));
		
					
	}
}
