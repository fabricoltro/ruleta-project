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
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.Opcion4Numeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion2NumeroDAO implements DAO {

	@Override
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		//mod by gcasas ---------------
		Statement consultar2n= conexion.createStatement();
		
		
		Opcion2Numeros op2num = (Opcion2Numeros)obj;
		List<Numero> numeros = op2num.getNumeros();
		//1-primedo debo obtener el id de los dos numeros
		int icomb2_id = getComb2_id(op2num.getNumeros(), consultar2n);
		
		StringBuffer sbValores = new StringBuffer("INSERT INTO ruleta.opciones_dos_numeros(COMB2_ID, APU_ID, OPD_SALDO) VALUES(");
		sbValores.append(icomb2_id);
		sbValores.append(",");		
		sbValores.append(op2num.getApuesta().getCodigo());
		sbValores.append(",");
		sbValores.append(op2num.getSaldo());		
		sbValores.append(");");
		agregar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	}

	@Override
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement eliminar = conexion.createStatement();
		
		Opcion2Numeros numero = (Opcion2Numeros)obj;
		StringBuffer sbValores = new StringBuffer("DELETE FROM ruleta.opciones_dos_numeros WHERE OPD_ID= ");
		sbValores.append(numero.getCodigo());
				
		eliminar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
		
	}

	@Override
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
	
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
		Statement consultarComb2n = conexion.createStatement();
		Opcion2Numeros numero = (Opcion2Numeros)obj;
		
		int comb2_id = this.getComb2_id(numero.getNumeros(), consultarComb2n);
		
		StringBuffer sbValores = new StringBuffer("UPDATE FROM opciones_dos_numeros set ");
		sbValores.append("comb2_id=");
		sbValores.append(comb2_id);
		sbValores.append("apu_id=");
		sbValores.append(numero.getApuesta().getCodigo());
		sbValores.append("opd_saldo=");
		sbValores.append(numero.getSaldo());
		sbValores.append("WHERE opd_id= ");
		sbValores.append(numero.getCodigo());
		
		modificar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
		
		
	}

	@Override
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		Statement consultarComb2n = conexion.createStatement();
		Opcion2Numeros numero = (Opcion2Numeros)obj;
		
		StringBuffer sb = new StringBuffer(	"SELECT jug.jug_id, jug.jug_nombre, jug.jug_apellido, jug.jug_alias,");
		sb.append(								"apu.apu_id, apu.apu_ronda,");
		sb.append(								"opd.opd_id, opd.opd_saldo, comb2.comb2_valor1, comb2.comb2_valor2");
		sb.append(							" FROM jugadores AS jug, apuestas AS apu, opciones_dos_numeros AS opd, combinaciones2numeros as comb2");
		sb.append(							" WHERE jug.jug_id = apu.jug_id");
		sb.append(								" AND apu.apu_id = opd.apu_id");
		sb.append(								" AND opd.comb2_id=comb2.comb2_id");
		if (numero!=null && !numero.isVacio()){
			if (numero.getCodigo()>0){
				sb.append("and opd_id=");
				sb.append(numero.getCodigo());
			}
		}
		ResultSet rs = leer.executeQuery(sb.toString());
		List opciones2Numeros = convertRsToObje(rs);
		ConnectionManager.desconectar();
		return opciones2Numeros;
	}
	
	private List convertRsToObje(ResultSet rs) throws SQLException{
		List<Opcion2Numeros> lstDosNum = new ArrayList<Opcion2Numeros>();
		Jugador jugador;
		Apuesta apuesta;
		while (rs.next()){
			jugador= new Jugador(rs.getInt("JUG_ID"), rs.getString("JUG_NOMBRE"), rs.getString("JUG_APELLIDO"), rs.getString("JUG_ALIAS"));
			apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
			Opcion2Numeros opd = new Opcion2Numeros(rs.getInt("opd.opd_saldo"));
			opd.setApuesta(apuesta);
			try {
				opd.addNUmero(new Numero(rs.getInt("comb2.comb2_valor1")));
				opd.addNUmero(new Numero(rs.getInt("comb2.comb2_valor2")));
			} catch (RuletaException e) {
				e.printStackTrace();
			}
			lstDosNum.add(opd);			
	}
		return lstDosNum;

	}
	
	private int getComb2_id(List<Numero> pNumeros, Statement pStat) throws SQLException{
		StringBuffer sql = new StringBuffer("select comb2_id from ruleta.combinaciones2numeros where ");
		sql.append("comb2_valor1=");
		sql.append(pNumeros.get(0).getValor());
		sql.append(" and comb2_valor2=");
		sql.append(pNumeros.get(1).getValor());
		ResultSet rs = pStat.executeQuery(sql.toString());
		rs.next();
		
		return rs.getInt("comb2_id");
	}

}
