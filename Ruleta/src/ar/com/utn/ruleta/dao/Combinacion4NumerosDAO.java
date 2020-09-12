package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.CuatroNumeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class Combinacion4NumerosDAO implements DAO {

	public Combinacion4NumerosDAO() {}

	@Override
	public void agregar(Object obj) throws ClassNotFoundException, SQLException{}

	@Override
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {}

	@Override
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {}

	@Override
	public List leer(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement leer = conexion.createStatement();
		
		StringBuffer sb = new StringBuffer("SELECT com2nun.comb4_id, com2num.comb4_valor1, com2num.comb4_valor2,");
		sb.append						  ("com2num.comb4_valor3, com2num.comb4_valor4");
		sb.append						  ("FROM combinaciones4numeros AS com2num");
		
		ResultSet rs = leer.executeQuery(sb.toString());
		List combinacion4Numeros = convertRsToObje(rs);
		ConnectionManager.desconectar();
		
		return combinacion4Numeros;

	}

	private List convertRsToObje(ResultSet rs) throws SQLException {
		
		List<CuatroNumeros> comb4numeros = new ArrayList<CuatroNumeros>();
		int id=0;
		int valor1=0;
		int valor2=0;
		int valor3=0;
		int valor4=0;
		
		while(rs.next()){
			
			id = rs.getInt("comb4_id");
			valor1 = rs.getInt("comb4_valor1");
			valor2 = rs.getInt("comb4_valor2");
			valor3 = rs.getInt("comb4_valor3");
			valor4 = rs.getInt("comb4_valor4");
			
			comb4numeros.add(new CuatroNumeros(id, valor1, valor2, valor3, valor4));
			
		}
		
		return comb4numeros;
	}

}
