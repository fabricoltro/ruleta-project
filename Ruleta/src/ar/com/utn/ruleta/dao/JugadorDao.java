package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.SelectIdStrategy;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.SelectJugadorStrategy;
import ar.com.utn.ruleta.modelo.dao.util.*;
import ar.com.utn.ruleta.modelo.*;

/**
 * @author Matias
 * Fecha: 06/06/2020
 * Esta clase corresponde a la clase Jugador de DAO para el acceso a la base de datos.
 */

//que los metodos reciban el objeto de la clase en vez de un objeto cualquiera
public class JugadorDao implements DAO {

	private List convertRsToObje(ResultSet rs) throws SQLException {
		List<Jugador> players = new ArrayList<Jugador>();
		while (rs.next()){
			players.add(new Jugador(rs.getInt("JUG_ID"), rs.getString("JUG_NOMBRE"),rs.getString("JUG_APELLIDO"),rs.getString("JUG_ALIAS")));			
	}
		return players;

}
	
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		Jugador player = (Jugador)obj;

		//crea un solo objeto
		StringBuffer sql = new StringBuffer("insert into ruleta.jugadores (JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS) values('");
		sql.append(player.getNombre());
		sql.append("','");
		sql.append(player.getApellido());
		sql.append("','");
		sql.append(player.getAlias());
		sql.append("');");
		agregar.executeUpdate(sql.toString());
		ConnectionManager.desconectar();
	}

	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		Jugador player = (Jugador)obj;
		
		StringBuffer sql = new StringBuffer("delete from jugadores where JUG_ID =");
		sql.append(player.getCodigo());
	
		agregar.executeUpdate(sql.toString());
		ConnectionManager.desconectar();
	}

	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
		Jugador player = (Jugador)obj;

		StringBuffer sql = new StringBuffer("update jugadores set JUG_NOMBRE= '");
		sql.append(player.getNombre());
		sql.append("', ");
		sql.append("JUG_APELLIDO= '");
		sql.append(player.getApellido());
		sql.append("', ");
		sql.append("JUG_ALIAS= '");
		sql.append(player.getAlias());
		sql.append("' where JUG_ID =");
		sql.append(player.getCodigo());
		
		modificar.executeUpdate(sql.toString());
		ConnectionManager.desconectar();

	}
	
	public List leerJugadores() throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		ResultSet rs = conexion.createStatement().executeQuery("SELECT * FROM ruleta.jugadores");
		List players = convertRsToObje(rs);
		ConnectionManager.desconectar();
		return players;
	}
	
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		Jugador player = (Jugador)obj;
		//Agregar nombre,apellido, like en alias, 
		//******************* inicio sin patron de diseño ******************************
//		StringBuffer sb = new StringBuffer("SELECT JUG_ID, JUG_NOMBRE, JUG_APELLIDO, JUG_ALIAS FROM ruleta.jugadores ");
//		if (player != null && !player.isVacio()){
//			if(player.getCodigo()>0) {
//				sb.append("WHERE JUG_ID=");
//				sb.append(player.getCodigo());
//			}else if(player.getAlias() !=null && !player.getAlias().isEmpty()) {
//				sb.append("WHERE JUG_ALIAS='");
//				sb.append(player.getAlias());
//				sb.append("' ");
//			}
//			else if(player.getNombre() !=null && !player.getNombre().isEmpty()) {
//				sb.append("WHERE JUG_NOMBRE='");
//				sb.append(player.getNombre());
//				sb.append("' ");
//			}
//			else if(player.getApellido() !=null && !player.getApellido().isEmpty()) {
//				sb.append("WHERE JUG_APELLIDO='");
//				sb.append(player.getApellido());
//				sb.append("' ");
//			}
//		}
		
		//*********************** fin sin patron de diseño *******************************

		//*************** inicio codigo con patron strategy ****************************************
		ResultSet rs = agregar.executeQuery(SelectJugadorStrategy.getInstance(player, SqlConstant.LIKE).getSql());
		// ****************fin con patron strategy *****************************************************+
		List players = convertRsToObje(rs);
		ConnectionManager.desconectar();
		return players;
	}
	
	public List leerMati(String campoFiltrar, String valor)throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		List players;
		
		StringBuffer sb = new StringBuffer("SELECT * FROM ruleta.jugadores WHERE ");
		sb.append(campoFiltrar);
		sb.append("= '");
		sb.append(valor);
		sb.append("'; ");
		
		players = convertRsToObje(leer.executeQuery(sb.toString()));
		ConnectionManager.desconectar();
		return players;
		
		
	}
		

}
