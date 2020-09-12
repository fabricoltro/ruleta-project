package ar.com.utn.ruleta.controller;

import java.sql.SQLException;
import java.util.List;

import ar.com.utn.ruleta.dao.DAO;
import ar.com.utn.ruleta.modelo.Model;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public interface Controller {
	public void agregarHandler(Model pmodel, DAO pdao) throws RuletaException, ClassNotFoundException, SQLException;
	public void modificarHandler(Model pmodel, DAO pdao) throws RuletaException, ClassNotFoundException, SQLException;
	public void eliminarHandler(Model pmodel, DAO pdao) throws RuletaException, ClassNotFoundException, SQLException;;
	public List leernarHandler(Model pmodel, DAO pdao) throws RuletaException , ClassNotFoundException, SQLException;;
}
