package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion1NumeroDAO implements DAO {
	

	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		
		Opcion1Numero op1num = (Opcion1Numero)obj;
		
		StringBuffer sbValores = new StringBuffer("INSERT INTO ruleta.opciones_un_numero(OPUN_VALOR, APU_ID, OPUN_SALDO) VALUES(");
		sbValores.append(op1num.getNumero().getValor());
		sbValores.append(",");
		sbValores.append(op1num.getApuesta().getCodigo());	
		sbValores.append(",");
		sbValores.append(op1num.getSaldo());		
		sbValores.append(");");
		agregar.executeUpdate(sbValores.toString());
		
	}	
	
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
		
		Opcion1Numero op1num = (Opcion1Numero)obj;
		
		StringBuffer sbValores = new StringBuffer("UPDATE FROM opciones_un_numeros set ");
		sbValores.append("APUN_VALOR= ");
		sbValores.append(op1num.getNumero().getValor());
		sbValores.append("APU_ID= ");
		sbValores.append(op1num.getApuesta().getCodigo());
		sbValores.append("WHERE OPUN_ID=");
		sbValores.append(op1num.getCodigo());
		
		modificar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
	}
	
	
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		 
		ConnectionManager.conectar(); 
		Connection conexion = ConnectionManager.getConexion();
		Statement eliminar = conexion.createStatement();
		
		Opcion1Numero op1num = (Opcion1Numero)obj;
		StringBuffer sbValores = new StringBuffer("DELETE FROM ruleta.opciones_un_numero WHERE OPUN_ID= ");
		sbValores.append(op1num.getCodigo());
				
		eliminar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	}
	
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		Opcion1Numero numero = (Opcion1Numero)obj;
		
		StringBuffer sb = new StringBuffer(	"SELECT jug.jug_id, jug.jug_nombre, jug.jug_apellido, jug.jug_alias,");
		sb.append(								"apu.apu_id, apu.apu_ronda,");
		sb.append(								"opd.opun_id, opd.opun_saldo, opd.opun_valor");
		sb.append(							" FROM jugadores AS jug, apuestas AS apu, opciones_un_numero AS opd");
		sb.append(							" WHERE jug.jug_id = apu.jug_id");
		sb.append(								" AND apu.apu_id = opd.apu_id");
		sb.append(								" AND opd.opun_valor=");
		sb.append(								numero.getNumero().getValor());
		if (numero!=null && !numero.isVacio()){
			if (numero.getCodigo()>0){
				sb.append("and opd_id=");
				sb.append(numero.getCodigo());
			}
		}
		ResultSet rs = leer.executeQuery(sb.toString());
		List opciones1Numero = convertRsToObje(rs);
		ConnectionManager.desconectar();
		return opciones1Numero;
	}

	private List convertRsToObje(ResultSet rs) throws SQLException {
		
		List<Opcion1Numero> lstDosNum = new ArrayList<Opcion1Numero>();
		Opcion1Numero numero;
		Jugador jugador;
		Apuesta apuesta;
		while (rs.next()){
			jugador= new Jugador(rs.getInt("JUG_ID"), rs.getString("JUG_NOMBRE"), rs.getString("JUG_APELLIDO"), rs.getString("JUG_ALIAS"));
			apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
			Opcion1Numero opd = new Opcion1Numero(rs.getInt("opd.opun_saldo"));
			opd.setApuesta(apuesta);
			try {
				opd.setNumero(new Numero(rs.getInt("opd.opun_valor")));
			} catch (RuletaException e) {
				e.printStackTrace();
			}
			lstDosNum.add(opd);			
	}
		return lstDosNum;

	}
}		
