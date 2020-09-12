package ar.com.utn.ruleta.modelo.dao.util.comb2num;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.DosNumeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class GenerarCombinaciones {
	private static List<DosNumeros> combinaciones = new ArrayList<DosNumeros>();

	
	public static List<DosNumeros> getCombinacions(){ return combinaciones; }
	
	public static List<DosNumeros> generar(){
		//estas son las combinaciones horizontales
		for (int fila=1;fila<35;fila+=3)
			for(int col=0;col<2;col++)
				combinaciones.add(new DosNumeros(fila + col, fila + col+1));
	   // estas son las combinaciones verticales
		for (int num=1;num<34;num++)			
				combinaciones.add(new DosNumeros(num , num +3 ));		
		return combinaciones;
	}
	public static void grabarCombinaciones() throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		
		for (DosNumeros dosNumeros : combinaciones) {
			StringBuffer sql = new StringBuffer("insert into ruleta.combinaciones2numeros(COMB2_VALOR1,COMB2_VALOR2) values(");
			sql.append(dosNumeros.getValor1());
			sql.append(",");
			sql.append(dosNumeros.getValor2());
			sql.append(")");
			agregar.executeUpdate(sql.toString());
			
		}
		ConnectionManager.desconectar();
	}
}
