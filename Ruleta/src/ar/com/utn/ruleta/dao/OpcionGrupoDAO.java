package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.OpcionGrupo;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class OpcionGrupoDAO implements DAO {

	@Override
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		OpcionGrupo OP1 = (OpcionGrupo)obj; //pregunta 
		
		StringBuffer sbValores = new StringBuffer("INSERT INTO ruleta.opcion_grupo(OPG_GRUPO, APU_ID, OPG_SALDO) VALUES(");
		sbValores.append(OP1.getGrupoConst());
		sbValores.append(",");
		sbValores.append(OP1.getApuesta().getCodigo());
		sbValores.append(",");
		sbValores.append(OP1.getSaldo());		
		sbValores.append(");");
		agregar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	

	}

	@Override
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement eliminar = conexion.createStatement();
		
		OpcionGrupo opg1 = (OpcionGrupo)obj;
		StringBuffer sbValores = new StringBuffer("DELETE FROM ruleta.opcion_grupo WHERE OPG_GRUPO= ");
		sbValores.append(opg1.getGrupoConst());
		sbValores.append(" AND APU_ID= ");
		sbValores.append(opg1.getApuesta().getCodigo());
				
		eliminar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	
	}

	@Override
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
	

	}

	@Override
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		
		return null;
	}

}
