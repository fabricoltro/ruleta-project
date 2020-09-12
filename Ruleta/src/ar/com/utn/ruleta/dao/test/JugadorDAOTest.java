package ar.com.utn.ruleta.dao.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.utn.ruleta.dao.JugadorDao;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.util.*;
import junit.framework.Assert;




public class JugadorDAOTest {
	static Connection con;
	static Statement stat;
	Jugador jugador;
	String crearJugador = "SELECT JUG_NOMBRE FROM ruleta.jugadores WHERE JUG_NOMBRE = 'nuevo_test';";
	String deleteJugador = "SELECT * FROM ruleta.jugadores WHERE JUG_NOMBRE = 'Mati_test' AND JUG_APELLIDO = 'Novoa' AND JUG_ALIAS='asd';";
	String modificarJugador = "SELECT * FROM ruleta.jugadores WHERE JUG_NOMBRE = 'Gaby_test' AND JUG_APELLIDO = 'Casas' AND JUG_ALIAS='dsa';";
	String modificarJugador2 = "SELECT * FROM ruleta.jugadores WHERE JUG_NOMBRE ='Nombre_modificado' AND JUG_APELLIDO ='Apellido_modificado' AND JUG_ALIAS = 'Alias_modificado';";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
        Statement consulta= con.createStatement();
        String sql;
        BufferedReader bf = new BufferedReader( new InputStreamReader( JugadorDAOTest.class.getResource( "JugadorCrear.sql" ).openStream() ) );
        while((sql = bf.readLine())!=null) {
        	if ( sql.trim().length() != 0 && !sql.startsWith( "--" ) ) {              
                  consulta.executeUpdate( sql ); // aca arma
               }
        }
        cm.desconectar();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
        Statement consulta= con.createStatement();
        String sql;
        BufferedReader bf = new BufferedReader( new InputStreamReader( JugadorDAOTest.class.getResource( "JugadoresEliminar.sql" ).openStream() ) );
        while((sql = bf.readLine())!=null) {
        	if ( sql.trim().length() != 0 && !sql.startsWith( "--" ) ) {              
                  consulta.executeUpdate( sql ); // aca arma
               }
        }
        cm.desconectar();
	}
	
	@Test
	public void agregarTest()throws Exception{
		JugadorDao jugadorDao = new JugadorDao();
	try {
		jugadorDao.agregar(new Jugador("nuevo_test", "sarasa", "asd_test"));
		ResultSet rs= stat.executeQuery(crearJugador);
		rs.next();
		assertEquals(rs.getString("JUG_NOMBRE"), "nuevo_test");
	} catch (ClassNotFoundException e) {
		assertTrue(false);
		e.printStackTrace();
	} catch (SQLException e) {
		assertTrue(false);
		e.printStackTrace();
		}
	}	
	
	@Test
	public void testEliminarConId() {
		JugadorDao jugadorDao = new JugadorDao();
		try {
			
			ResultSet rs = stat.executeQuery(deleteJugador);
			rs.next();			
			Jugador jug = new Jugador(rs.getInt("JUG_ID"),rs.getString("JUG_NOMBRE"), rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS"));		
			jugadorDao.eliminar(jug);
			rs =stat.executeQuery(deleteJugador);
			assertFalse(rs.next());
			rs.close();
		} catch (SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testModificar() {
		JugadorDao jugadorDao = new JugadorDao();
		try {
			ResultSet rs=stat.executeQuery(modificarJugador);
			rs.next();		
			
			Jugador jug = new Jugador(rs.getInt("JUG_ID"),rs.getString("JUG_NOMBRE"), rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS"));	
			jug.setAlias("Alias_modificado");
			jug.setApellido("Apellido_modificado");
			jug.setNombre("Nombre_modificado");
			jugadorDao.modificar(jug);
			
			rs=stat.executeQuery(modificarJugador2);
			rs.next();
			
			//Va a fallar antes si no encuentra en sql
			assertEquals(rs.getString("JUG_NOMBRE"), "Nombre_modificado");
			assertEquals(rs.getString("JUG_APELLIDO"), "Apellido_modificado");
			assertEquals(rs.getString("JUG_ALIAS"), "Alias_modificado");
			rs.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
	
	//Porquee recibe un objeto?, deberia recibir un parametro y leer todos los resultados de la BD filtrando por ese parametro?
	@Test
	public void testLeerPorNombre() {
		JugadorDao jugadorDao = new JugadorDao();
		Jugador jugLucas = new Jugador("Lucas_test",null,null);
		try {
			//List jugadores = jugadorDao.leer(jugLucas);
			Assert.assertTrue(((Jugador) jugadorDao.leer(jugLucas).get(0)).getNombre().equals("Lucas_test"));
			//Assert.assertTrue(((Jugador) jugadores.get(0)).getNombre().equals("Lucas_test"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testLeerMati() {
		JugadorDao jugadorDao = new JugadorDao();
		try {
			for(Object a : jugadorDao.leerMati("JUG_NOMBRE", "Mati_test")) {
				System.out.println(a);
			}
			assertTrue(jugadorDao.leerMati("JUG_NOMBRE", "Matai_test").isEmpty());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
	
	
	

	@Before
	public void setUp() throws Exception {
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		stat = con.createStatement();

	}

	@After
	public void tearDown() throws Exception {
		con.close();
	}
	
	
}
