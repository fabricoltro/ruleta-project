package ar.com.utn.ruleta.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	public void agregar(Object obj) throws ClassNotFoundException, SQLException;
	public void eliminar(Object obj)throws ClassNotFoundException, SQLException;
	public void modificar(Object obj)throws ClassNotFoundException, SQLException;
	public List leer(Object obj)throws ClassNotFoundException, SQLException;

}