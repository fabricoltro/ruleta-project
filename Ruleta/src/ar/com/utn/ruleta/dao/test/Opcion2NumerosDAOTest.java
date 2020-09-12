package ar.com.utn.ruleta.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.utn.ruleta.dao.Opcion2NumeroDAO;
import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion2NumerosDAOTest {

	static Connection con;
	Statement stat;
	Opcion2Numeros opcion = null;
	Jugador jugador = null;
	Apuesta apuesta = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion2NumerosDAOTest.class.getResource( "Opcion2NumerosCrear.sql" ).openStream() ) );
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
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion2NumerosDAOTest.class.getResource( "Opcion2NumerosEliminar.sql" ).openStream() ) );
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
		
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery("Select JUG_ID,JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS from ruleta.jugadores where JUG_NOMBRE = 'Fernando_test'");
		if (rs.next()){
			jugador = new Jugador(rs.getInt("JUG_ID"),rs.getString("JUG_NOMBRE"),rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS"));
		}
		
		rs = stat.executeQuery("SELECT APU_ID,APU_RONDA FROM ruleta.apuestas where JUG_ID =" + jugador.getCodigo());
		if (rs.next()){
			apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
		}

	}


	@After
	public void tearDown() throws Exception {

		jugador = null;
		apuesta = null;
		con.close();
	
	}
	
	@Test
	public void testAgregar() {
		Opcion2NumeroDAO OpcionDao = new Opcion2NumeroDAO();
		List<Numero> numeros = new ArrayList<Numero>();
		try {
			numeros.add(new Numero(5));
			numeros.add(new Numero(6));
			
			OpcionDao.agregar(new Opcion2Numeros(0,numeros,1000000,apuesta));
			
			StringBuffer sbSQL = new StringBuffer	("select  comb2_id, opd_saldo, apu_id ");
			sbSQL.append							("from ruleta.opciones_dos_numeros where apu_id =");
			sbSQL.append							(apuesta.getCodigo());
			sbSQL.append							(" and comb2_id=4");
			
			ResultSet rs=stat.executeQuery(sbSQL.toString());
			rs.next();
			assertEquals(rs.getInt("APU_ID"), apuesta.getCodigo());
		} catch (ClassNotFoundException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (RuletaException e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testEliminar() {
		Opcion2NumeroDAO opcion = new Opcion2NumeroDAO();
		try {
			StringBuffer 	sqlDel = new StringBuffer	("SELECT opd_id, comb2_id, apu_id, opd_saldo "); 
							sqlDel.append				("FROM ruleta.opciones_dos_numeros ");
							sqlDel.append				("WHERE comb2_id=1 and apu_id=");
							sqlDel.append				(apuesta.getCodigo());
							
			
			ResultSet rs=stat.executeQuery(sqlDel.toString());
			rs.next();	
			
			Opcion2Numeros opc = new Opcion2Numeros(rs.getInt("OPD_ID"));			
			opcion.eliminar(opc);

			ResultSet rs2=stat.executeQuery(sqlDel.toString());
			//next deberia darle false, o sea no hay un proximo
			assertFalse(rs2.next());
			rs.close();
			rs2.close();	
		} catch (SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
	}
	@Test
	public void testModificars() {
		//TODO compleetar el testeo  modificar 
		fail("estaria faltando este esta solamente a forma de recordatorio");
		
	}
	@Test
	public void testLeer() {
		//TODO compleetar el modificar 
		fail("estaria faltando este esta solamente a forma de recordatorio");
		
	}
}
