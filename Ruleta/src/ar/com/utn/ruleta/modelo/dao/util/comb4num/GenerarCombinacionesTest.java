package ar.com.utn.ruleta.modelo.dao.util.comb4num;

import java.sql.SQLException;

public class GenerarCombinacionesTest {

	public static void main(String[] args) {
		System.out.println(GenerarCombinaciones.generar());
		System.out.println("cantidad=" + GenerarCombinaciones.getCombinacions().size());
		try {
			GenerarCombinaciones.grabarCombinaciones();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
