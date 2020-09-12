package ar.com.utn.ruleta.view;

import java.sql.SQLException;

/**
 * @author Gabriel
 *Esta inferface tiene la finalidad de obligar a las clases que la implementen a actualiza sus datos 
 */
public interface  View {
	public void refresh() throws ClassNotFoundException, SQLException;

}
