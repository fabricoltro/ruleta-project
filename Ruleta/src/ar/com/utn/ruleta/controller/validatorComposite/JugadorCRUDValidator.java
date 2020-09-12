package ar.com.utn.ruleta.controller.validatorComposite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Jugador;

/**
 * @author Gabriel
 * Esta clase corresponde al patrón compmosite donde la clase madre conoce a todos sus hijos teniendo como finalidad devolver el 
 * conjunto de errores producidos al momento de realizar un alta, cada una de las clases hijas corresponde a un error y en el caso de producirse deberá sumarse para ser 
 * devuelva junto con los otros erorres producidos.
 */

public abstract class JugadorCRUDValidator {
	protected static Jugador jugador		;
	
	//1- algun campo vacio	
	//2- El codigo debe estar en 0
	//3- Que el Allias no sea repetido
	
	/**
	 * Este método devuelve la suma de todos los errores producidos en cada una de las clases hijas al momento de controlar el agregar
	 * @param pJugador corresponde al jugador a evaluar, sobre el cual se verificaran cada uno de sus atribudos
	 * @return devuelve una String con la suma de todos los errores producidos o una cadena vacía para el caso de no tener errores
	 * @throws ClassNotFoundException es un error de la base de datos y esta relacionado con no encontrar el driver que permite accedera a la base de datos.
	 * @throws SQLException corresponde a un error de sql 
	 */
	public static String getErroresAlAgregar(Jugador pJugador) throws ClassNotFoundException, SQLException {
		jugador = pJugador;
		List<JugadorCRUDValidator> errores = new ArrayList<JugadorCRUDValidator>();
		errores.add(new ExisteCampoVacioJugadorAgregarModificarValidatos());
		errores.add(new CodigoDebeSerCeroJugAgrValidator());
		errores.add(new AliasRepetidoJugAgregModifValidator());
		
		StringBuffer sbTodosLosErrores = new StringBuffer();
		for (JugadorCRUDValidator errorAgr : errores) {
			if(errorAgr.verificarError()) {
				
				sbTodosLosErrores.append(errorAgr.getError());
				sbTodosLosErrores.append("\n");
			}
				
		}
		return sbTodosLosErrores.toString();
	}

	/**
	 * Este método devuelve la suma de todos los errores producidos en cada una de las clases hijas al momento de controlar el modificar
	 * @param pJugador corresponde al jugador a evaluar, sobre el cual se verificaran cada uno de sus atribudos
	 * @return devuelve una String con la suma de todos los errores producidos o una cadena vacía para el caso de no tener errores
	 * @throws ClassNotFoundException es un error de la base de datos y esta relacionado con no encontrar el driver que permite accedera a la base de datos.
	 * @throws SQLException corresponde a un error de sql 
	 */

	public static String getErroresAlModificar(Jugador pJugador) throws ClassNotFoundException, SQLException {
		//que validaciones necesito?
		//validar que el alias no se repita y que el resto de los campos estan completos
		
		jugador = pJugador;
		List<JugadorCRUDValidator> errores = new ArrayList<JugadorCRUDValidator>();
		errores.add(new CodigoMayorQueCeroModifEliminarValidator());
		errores.add(new AliasRepetidoJugAgregModifValidator());
		errores.add(new ExisteCampoVacioJugadorAgregarModificarValidatos()); //mod by gcasas
				
		StringBuffer sbTodosLosErrores = new StringBuffer();
		for (JugadorCRUDValidator errorAgr : errores) {
			if(errorAgr.verificarError()) {
	
				sbTodosLosErrores.append(errorAgr.getError());
				sbTodosLosErrores.append("\n");
			}
				
		}
		
		return sbTodosLosErrores.toString();
	}
	
	/**
	 * Este método devuelve la suma de todos los errores producidos en cada una de las clases hijas al momento de controlar el modificar
	 * @param pJugador corresponde al jugador a evaluar, sobre el cual se verificaran cada uno de sus atribudos
	 * @return devuelve una String con la suma de todos los errores producidos o una cadena vacía para el caso de no tener errores
	 * @throws ClassNotFoundException es un error de la base de datos y esta relacionado con no encontrar el driver que permite accedera a la base de datos.
	 * @throws SQLException corresponde a un error de sql 
	 */
	
	public static String getErroresAlEliminar(Jugador pJugador) throws ClassNotFoundException, SQLException {

		jugador = pJugador;
		List<JugadorCRUDValidator> errores = new ArrayList<JugadorCRUDValidator>();
		errores.add(new CodigoMayorQueCeroModifEliminarValidator());
		
		StringBuffer sbTodosLosErrores = new StringBuffer();
		for (JugadorCRUDValidator errorAgr : errores) {
			if(errorAgr.verificarError()) {
				sbTodosLosErrores.append(errorAgr.getError());
				sbTodosLosErrores.append("\n");
			}
		}
		
		
    return sbTodosLosErrores.toString();
	}
	
	
	/**
	 * Este método sirve para que cada una de las clases hijas determise si se produce o no el error que tiene asignado
	 * 
	 * @return devuelve un true en el caso que el error asignado se cumple y false cuando dicho error no se cumple
	 * @throws ClassNotFoundException es un error de la base de datos y esta relacionado con no encontrar el driver que permite accedera a la base de datos.
	 * @throws SQLException corresponde a un error de sql 
	 */
	public abstract boolean verificarError() throws ClassNotFoundException, SQLException;
	
	/**
	 * Este metodo esta relacionado con la descripción del error que se cumple al momento de verificase que esta clase tiene el error asignado
	 * @return
	 */
	public abstract String getError();
	
	
}
