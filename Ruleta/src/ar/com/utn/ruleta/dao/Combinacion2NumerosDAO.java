package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import ar.com.utn.ruleta.modelo.DosNumeros;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class Combinacion2NumerosDAO implements DAO {

	public Combinacion2NumerosDAO() {}

	@Override
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		
		
	}
	@Override
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {}
	
	@Override
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {}
	@Override
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		
		StringBuffer sb = new StringBuffer("SELECT com2num.comb2_id, com2num.comb2_valor1, com2num.comb2_valor2 ");
		sb.append						  ("FROM combinaciones2numeros AS com2num");
		
		ResultSet rs = leer.executeQuery(sb.toString());
		List combinacion2Numeros = convertRsToObje(rs);
		ConnectionManager.desconectar();
		
		return combinacion2Numeros;
		
		
	}// convert rssssss
		private List convertRsToObje(ResultSet rs) throws SQLException {
		
		List<DosNumeros> comb2numeros = new ArrayList<DosNumeros>();
		int id=0;
		int valor1=0;
		int valor2=0;
		
		while(rs.next()){
			
		id = rs.getInt("comb2_id");
		valor1 = rs.getInt("comb2_valor1");
		valor2 = rs.getInt("comb2_valor2");
			
		comb2numeros.add(new DosNumeros(id, valor1, valor2));
			
		}
		
		return comb2numeros;
	}
	
}
