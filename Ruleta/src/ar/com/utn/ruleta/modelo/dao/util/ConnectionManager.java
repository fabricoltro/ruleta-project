package ar.com.utn.ruleta.modelo.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection con;
	
	public static Connection getConexion() {
		return con;
	}
	public static  void conectar() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sae","root", "admin");
		
	}
	public static void desconectar() throws SQLException{
		con.close();
		
	}

	
}
