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

import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.dao.Opcion4NumeroDAO;
import ar.com.utn.ruleta.modelo.Opcion4Numeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;


public class Opcion4NumerosDAOTest {

	static Connection con;
	Statement stat;
	Opcion4Numeros opcion = null;
	Jugador jugador = null;
	Apuesta apuesta = null;
	
@BeforeClass
public static void setUpBeforeClass() throws Exception {
	//1-este es el primer metodo en ejecutarse y 
	//normalmente esta relacionado con el lote de pruebas.
	ConnectionManager cm = new ConnectionManager();
	cm.conectar();
	con = cm.getConexion();
	
    Statement consulta= con.createStatement();

    String sql = "";
    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion4NumerosDAOTest.class.getResource( "Opcion4NumeroCrear.sql" ).openStream() ) );
    while ( (sql = bf.readLine()) != null ) {
       if ( sql.trim().length() != 0 &&
            !sql.startsWith( "--" ) ) {              
          consulta.executeUpdate( sql ); // aca arma
       }
    }
    cm.desconectar();
}

@AfterClass
public static void tearDownAfterClass() throws Exception {
	//este es el ultimo metodo en ejecutarse
	//noremalmente relacionado con la eliminacion del lote de pruebas
	ConnectionManager cm = new ConnectionManager();
	cm.conectar();
	con = cm.getConexion();
	
    Statement consulta= con.createStatement();

    String sql = "";
    BufferedReader bf = new BufferedReader( new InputStreamReader( Opcion4NumerosDAOTest.class.getResource( "Opcion4NumeroEliminar.sql" ).openStream() ) );
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
	//2-se ejecuta antes de cada testeo
	ConnectionManager cm = new ConnectionManager();
	cm.conectar();
	con = cm.getConexion();
	stat = con.createStatement();
	ResultSet rs = stat.executeQuery("Select JUG_ID,JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS from ruleta.jugadores where JUG_NOMBRE = 'Matias_test'");
	rs.next();
	jugador = new Jugador(rs.getInt("JUG_ID"),rs.getString("JUG_NOMBRE"),rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS"));
	rs = stat.executeQuery("SELECT APU_ID,APU_RONDA FROM ruleta.apuestas where JUG_ID =" + jugador.getCodigo());
	rs.next();
	apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
}


@After
public void tearDown() throws Exception {
	//3-Despues de cada testeo
	jugador = null;
	apuesta = null;
	con.close();
}


@Test
public void testAgregar() {
	Opcion4NumeroDAO OpcionDao = new Opcion4NumeroDAO();
	List<Numero> numeros = new ArrayList<Numero>();
	try {
		numeros.add(new Numero(30));
		numeros.add(new Numero(31));
		numeros.add(new Numero(32));
		numeros.add(new Numero(33));
		OpcionDao.agregar(new Opcion4Numeros(numeros));
		StringBuffer sbSQL = new StringBuffer("select OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID");
		sbSQL.append(" from opciones_cuatro_numeros where APU_ID=");
		sbSQL.append(apuesta.getCodigo());
		sbSQL.append(" and OPCUA_VALO1 =30");
		sbSQL.append(" and OPCUA_VALO2 =31");
		sbSQL.append(" and OPCUA_VALO3 =32");
		sbSQL.append(" and OPCUA_VALO4 =33");
		ResultSet rs=stat.executeQuery(sbSQL.toString());
		rs.next();
		assertEquals(rs.getString("APU_ID"), apuesta.getCodigo());
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
	Opcion4NumeroDAO opcion = new Opcion4NumeroDAO();
	try {
				
		ResultSet rs=stat.executeQuery("select *" +
				" from opciones_cuatro_numeros" + 
				" where OPCUA_ID='1'");
		rs.next();			
		Opcion4Numeros opc=null;// = new Opcion4Numeros(rs.getInt("OPCUA_ID"), rs.getInt("OPCUA_VALOR1"));			
		opcion.eliminar(opc);

		ResultSet rs2=stat.executeQuery("select prov_id, prov_nombre" +
				" from provincias" + 
				" where prov_nombre='Buenos Aires_test'");
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
public void testModificar() {
	fail("Not yet implemented");
	
}

@Test
public void testLeer_porNumeros() {
	fail("Not yet implemented");	
}
@Test
public void testLeer_porCodigo() {
	fail("Not yet implemented");	
}
}



