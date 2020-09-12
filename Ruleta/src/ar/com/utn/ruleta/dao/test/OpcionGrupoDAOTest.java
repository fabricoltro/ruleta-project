package ar.com.utn.ruleta.dao.test;

import static org.junit.Assert.*;

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

import ar.com.utn.ruleta.dao.DAO;
import ar.com.utn.ruleta.dao.Opcion1NumeroDAO;
import ar.com.utn.ruleta.dao.OpcionGrupoDAO;
import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.OpcionGrupo;
import ar.com.utn.ruleta.modelo.OpcionGrupoNegro;
import ar.com.utn.ruleta.modelo.OpcionGrupoRojo;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class OpcionGrupoDAOTest {
	static Connection con;
	Statement stat;
	ResultSet rs;
	
	OpcionGrupo opcionAgregar = null;
	//mod by gcasas
	OpcionGrupo opcionEliminar = null;
	OpcionGrupo opcionModificar = null;
	OpcionGrupo opcionLeer = null;
	
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
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion1NumeroDAOTest.class.getResource( "OpcionGrupoCrear.sql" ).openStream() ) );
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
	    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion1NumeroDAOTest.class.getResource( "OpcionGrupoEliminar.sql" ).openStream() ) );
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
		
		
		rs = stat.executeQuery("Select JUG_ID,JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS from ruleta.jugadores where JUG_ALIAS = 'soyLucasBro'");
		if (rs.next()){
			jugador = new Jugador(rs.getInt("JUG_ID"),rs.getString("JUG_NOMBRE"),rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS"));
		}
		
		rs = stat.executeQuery("SELECT APU_ID,APU_RONDA FROM ruleta.apuestas where JUG_ID =" + jugador.getCodigo());
		if (rs.next()){
			apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
		}
		//el que se agrega es del grupo 200 
		opcionAgregar = new OpcionGrupoRojo(500,apuesta);

		StringBuffer sql = new StringBuffer("SELECT OPG_ID,APU_ID, OPG_GRUPO, OPG_SALDO from ruleta.opcion_grupo where APU_ID =");
		sql.append(apuesta.getCodigo());		
		sql.append(" and OPG_GRUPO=100");
		
		rs = stat.executeQuery(sql.toString());
		if (rs.next()){
			//este es el factory que con el numero me  trae el obteto
			opcionEliminar = OpcionGrupo.getInstance(rs.getInt("OPG_GRUPO"));
			opcionEliminar.setSaldo(rs.getInt("OPG_SALDO"));
			opcionEliminar.setApuesta(apuesta);
		}
	
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		jugador 		= null;
		apuesta 		= null;
		
		opcionAgregar 	= null;
		opcionEliminar 	= null;
		opcionModificar = null;
		
		con.close();
		
	}

	@Test
	public void testAgregar() throws ClassNotFoundException, SQLException {
		OpcionGrupoDAO opcionDao = new OpcionGrupoDAO();
			opcionDao.agregar(opcionAgregar);
			
			StringBuffer sbSQL = new StringBuffer("select OPG_GRUPO, APU_ID, OPG_SALDO ");
			sbSQL.append("from ruleta.opcion_grupo where apu_id = ");
			sbSQL.append(apuesta.getCodigo());
			sbSQL.append(" and OPG_GRUPO=" + opcionAgregar.getGrupoConst());
			
			ResultSet rs=stat.executeQuery(sbSQL.toString());
			rs.next();
			assertEquals(rs.getInt("APU_ID"), apuesta.getCodigo());
			
	}

	@Test
	public void testEliminar() throws ClassNotFoundException, SQLException {
		OpcionGrupoDAO opcion2 = new OpcionGrupoDAO();
		opcion2.eliminar(opcionEliminar);
		
		StringBuffer sql = new StringBuffer("SELECT OPG_ID,APU_ID, OPG_GRUPO, OPG_SALDO from ruleta.opcion_grupo where APU_ID =");
		sql.append(apuesta.getCodigo());		
		sql.append(" and OPG_GRUPO=100");
		
		rs = stat.executeQuery(sql.toString());
		
		assertFalse(rs.next());
		

	}
	/*
	@Test
	public void testModificar() {
		
	}
	
	
	@Test
	public void testLeer() {
		fail("Not yet implemented");
	}*/

}
