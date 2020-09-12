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


public class Opcion4NumeroDAO implements DAO{
	
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		//mod by gcasas----------------
		Statement consultar4n = conexion.createStatement();
		
		Opcion4Numeros op4num = (Opcion4Numeros)obj;
		List<Numero> numeros = op4num.getNumeros();
		//1-debo obtener el id de los 4 numeros
		
		int icomb4_id=getcomb4_id(op4num.getNumeros(), consultar4n);
		
		
		StringBuffer sbValores = new StringBuffer("INSERT INTO ruleta.opciones_cuatro_numeros(COMB4_ID, APU_ID, OPCUA_SALDO) values(");		
		sbValores.append(icomb4_id);
		sbValores.append(",");
		sbValores.append(op4num.getApuesta().getCodigo());
		sbValores.append(",");
		sbValores.append(op4num.getSaldo());
		sbValores.append(");");
		agregar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
	}
	
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement eliminar = conexion.createStatement();
		Opcion4Numeros numero = (Opcion4Numeros)obj;
		
		StringBuffer sbValores = new StringBuffer("DELETE FROM ruleta.opciones_cuatro_numeros WHERE OPCUA_ID= ");
		sbValores.append(numero.getCodigo());		
		
		eliminar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
		
	}
	
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
		//mod by gcasas
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
		Statement consultarComb4n = conexion.createStatement();	
		
		Opcion4Numeros numero = (Opcion4Numeros)obj;
		
		int comb4_id = getcomb4_id(numero.getNumeros(), consultarComb4n);

		StringBuffer sbValores = new StringBuffer("UPDATE FROM opciones_cuatro_numeros set ");
		sbValores.append("comb4_id=");
		sbValores.append(comb4_id);
		sbValores.append("apu_id=");
		sbValores.append(numero.getApuesta().getCodigo());
		sbValores.append("opcua_saldo=");
		sbValores.append(numero.getSaldo());
		sbValores.append("WHERE opcua_id= ");
		sbValores.append(numero.getCodigo());		
		
		modificar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
			
	}
	
	
		public List leer(Object obj) throws ClassNotFoundException, SQLException {
			
			ConnectionManager.conectar();
			Connection conexion = ConnectionManager.getConexion();
			Statement leer = conexion.createStatement();
			Statement consultarComb2n = conexion.createStatement();
			Opcion2Numeros numero = (Opcion2Numeros)obj;
			
			StringBuffer sb = new StringBuffer(	"SELECT jug.jug_id, jug.jug_nombre, jug.jug_apellido, jug.jug_alias,");
			sb.append(								"apu.apu_id, apu.apu_ronda,");
			sb.append(								"opcua.opcua_id, ipcua.opcua_saldo, comb4.comb4_valor1, comb4.comb4_valor2, comb4.comb4_valor3, comb4.comb4_valor4");
			sb.append(							" FROM jugadores AS jug, apuestas AS apu, opciones_cuatro_numeros AS opua, combinaciones4numeros as comb4");
			sb.append(							" WHERE jug.jug_id = apu.jug_id");
			sb.append(								" AND apu.apu_id = opcua.apu_id");
			sb.append(								" AND opcua.comb4_id=comb4.comb4_id");
			if (numero!=null && !numero.isVacio()){
				if (numero.getCodigo()>0){
					sb.append("and opcua_id=");
					sb.append(numero.getCodigo());
				}
			}
			ResultSet rs = leer.executeQuery(sb.toString());
			List opciones2Numeros = convertRsToObje(rs);
			ConnectionManager.desconectar();
			return opciones2Numeros;
		}
		private List convertRsToObje(ResultSet rs) throws SQLException {
			List<Opcion4Numeros> lstCuatroNum = new ArrayList<Opcion4Numeros>();
			Jugador jugador;
			Apuesta apuesta;			
			while (rs.next()){
				jugador= new Jugador(rs.getInt("JUG_ID"), rs.getString("JUG_NOMBRE"), rs.getString("JUG_APELLIDO"), rs.getString("JUG_ALIAS"));
				apuesta = new Apuesta(rs.getInt("APU_ID"), null, null, jugador);
				Opcion4Numeros opcua = new Opcion4Numeros(rs.getInt(""));
				opcua.setApuesta(apuesta);
				try {
					opcua.addNUmero(new Numero(rs.getInt("comb4.comb4_valor1")));
					opcua.addNUmero(new Numero(rs.getInt("comb3.comb4_valor2")));
					opcua.addNUmero(new Numero(rs.getInt("comb3.comb4_valor3")));
					opcua.addNUmero(new Numero(rs.getInt("comb3.comb4_valor4")));
				} catch (RuletaException e) {
					e.printStackTrace();
				}
				lstCuatroNum.add(opcua);			
		}
			return lstCuatroNum;
	
			}
			
			private int getcomb4_id(List<Numero> pNumeros, Statement pStat) throws SQLException {
				StringBuffer sql = new StringBuffer("select comb4_id from ruleta.combinaciones4numeros where ");
				sql.append("comb4_valor1=");
				sql.append(pNumeros.get(0).getValor());
				sql.append(" and comb4_valor2=");
				sql.append(pNumeros.get(1).getValor());
				sql.append("comb4_valor3=");
				sql.append(pNumeros.get(2).getValor());
				sql.append(" and comb4_valor4=");
				sql.append(pNumeros.get(3).getValor());

				
				ResultSet rs = pStat.executeQuery(sql.toString());
				rs.next();
				
				return rs.getInt("comb4_id");			}
			
	
	}
