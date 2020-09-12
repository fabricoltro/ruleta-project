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

public class JugadorModificarValidatorTest {
	static Connection con;
	Statement stat;
	Jugador jugador;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( JugadorModificarValidatorTest.class.getResource( "ValidatorAliasCrear.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql );
	       }
	    }
	    cm.desconectar();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
	    Statement consulta= con.createStatement();

	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( JugadorModificarValidatorTest.class.getResource( "ValidatorAliasEliminar.sql" ).openStream() ) );
	    while ( (sql = bf.readLine()) != null ) {
	       if ( sql.trim().length() != 0 &&
	            !sql.startsWith( "--" ) ) {              
	          consulta.executeUpdate( sql ); // aca arma
	       }
	    }
	    
	    cm.desconectar();
	}
	
	@Before
	public void setUp() throws Exception {
		//TODO Matias hacer que todos los testeos esten en verde
		jugador = new Jugador("Gabriel", "Casas","gcasas");
	}

	@After
	public void tearDown() throws Exception {
		jugador=null;
	}

	@Test
	public void testGetErroresCampoVacioNombre() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(2,"", "Casas_test", "gcasas_test");
		
		assertEquals("El nombre, el apellido o el Alias estan vacios\n", JugadorCRUDValidator.getErroresAlModificar(jugador));
	}

	@Test
	public void testGetErroresCampoVacioApellido() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(3,"Gabriel_test", "", "gcasasOtroDiferente_test");
		
		assertEquals("El nombre, el apellido o el Alias estan vacios\n", JugadorCRUDValidator.getErroresAlModificar(jugador));
	}

	@Test
	public void testGetErroresCampoVacioAlias() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(4,"Gabriel_test", "Casas_test", "");
		
		assertEquals("El nombre, el apellido o el Alias estan vacios\n", JugadorCRUDValidator.getErroresAlModificar(jugador));
	}
	@Test
	public void testGetErroresAliasRepetido() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(5,"Gabriel_test", "Casas_test", "alias_test");
		
		assertEquals("El alias esta repetido\n", 	JugadorCRUDValidator.getErroresAlModificar(jugador));
	}

	@Test
	public void testGetErroresCodigoIgualCero() throws ClassNotFoundException, SQLException {
		jugador = new Jugador(0,"Gabriel_test", "Casas_test", "alisas_test");
		
		assertEquals("El codigo debe ser mayor que 0(cero)\n", 	JugadorCRUDValidator.getErroresAlModificar(jugador));
	}

}
