package ar.com.utn.ruleta.modelo.dao.util.comb4num;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.CuatroNumeros;
import ar.com.utn.ruleta.modelo.DosNumeros;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;

public class GenerarCombinaciones {
	private static List<CuatroNumeros> combinaciones = new ArrayList<CuatroNumeros>();

	
	public static List<CuatroNumeros> getCombinacions(){ return combinaciones; }
	
	public static List<CuatroNumeros> generar(){
		//estas son las combinaciones
		
		for (int valor1=1;valor1<=32;valor1++)
			if(valor1%3!=0){
				combinaciones.add(new CuatroNumeros(valor1,valor1+1,valor1+3,valor1+4));
			}
		return combinaciones;
		}
	public static void grabarCombinaciones() throws ClassNotFoundException, SQLException{
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		
		for (CuatroNumeros cuatroNumeros : combinaciones) {
			StringBuffer sql = new StringBuffer("insert into ruleta.combinaciones4numeros(COMB4_VALOR1,COMB4_VALOR2, COMB4_VALOR3, COMB4_VALOR4) values(");
			sql.append(cuatroNumeros.getValor1());
			sql.append(",");
			sql.append(cuatroNumeros.getValor2());
			sql.append(",");
			sql.append(cuatroNumeros.getValor3());
			sql.append(",");
			sql.append(cuatroNumeros.getValor4());
			sql.append(")");
			
			agregar.executeUpdate(sql.toString());
			
		}
		ConnectionManager.desconectar();
	}
}
