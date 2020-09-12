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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import ar.com.utn.ruleta.dao.Opcion1NumeroDAO;
import ar.com.utn.ruleta.dao.Opcion2NumeroDAO;
import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion1NumeroDAOTest {
	static Connection con;
	Statement stat;
	Opcion1Numero opcion = null;
	Jugador jugador = null;
	Apuesta apuesta = null;
	Numero numero = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ConnectionManager cm = new ConnectionManager();
		cm.conectar();
		con = cm.getConexion();
		
	    Statement consulta= con.createStatement();
	
	    String sql = "";
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion1NumeroDAOTest.class.getResource( "Opcion1NumeroCrear.sql" ).openStream() ) );
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
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion1NumeroDAOTest.class.getResource( "Opcion1NumeroEliminar.sql" ).openStream() ) );
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
		
		ResultSet rs = stat.executeQuery("Select JUG_ID,JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS from ruleta.jugadores where JUG_ALIAS = 'ferdi'");
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
		Opcion1NumeroDAO OpcionDao = new Opcion1NumeroDAO();
		try {
			Numero numero = new Numero(36);
			
			OpcionDao.agregar(new Opcion1Numero(100,numero, apuesta));
			
			StringBuffer sbSQL = new StringBuffer("select OPUN_VALOR, APU_ID, OPUN_SALDO ");
			sbSQL.append("from ruleta.opciones_un_numero where apu_id = ");
			sbSQL.append(apuesta.getCodigo());
			sbSQL.append(" and OPUN_VALOR=" + numero.getValor());
			
			ResultSet rs=stat.executeQuery(sbSQL.toString());
			rs.next();
			assertEquals(rs.getInt("APU_ID"), apuesta.getCodigo());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (RuletaException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	
	}
	@Test
	public void testEliminar(){
		Opcion1NumeroDAO opcion = new Opcion1NumeroDAO();
		try {
			Numero numero2 = new Numero(2);
			
			StringBuffer 	sqlDel = new StringBuffer	("SELECT OPUN_ID,OPUN_VALOR,APU_ID,OPUN_SALDO "); 
							sqlDel.append				("FROM ruleta.opciones_un_numero ");
							sqlDel.append				("WHERE OPUN_VALOR=" + numero2.getValor());
							sqlDel.append				(" AND APU_ID=" + apuesta.getCodigo());

			
			ResultSet rs=stat.executeQuery(sqlDel.toString());
			rs.next();	
			
			Opcion1Numero opc = new Opcion1Numero(rs.getInt("OPUN_ID"));	
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
		}catch (RuletaException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	@Test
	public void testModificar(){
		fail("Not yet implemented");
		//TODO Fabri
	}
	
	@Test
	public void testLeer(){
		fail("Not yet implemented");
		//TODO Fabri
	}
	
}