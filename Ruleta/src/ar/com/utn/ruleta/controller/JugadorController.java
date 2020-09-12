package ar.com.utn.ruleta.controller;

import java.sql.SQLException;
import java.util.List;

import ar.com.utn.ruleta.controller.validatorComposite.JugadorCRUDValidator;
import ar.com.utn.ruleta.dao.DAO;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Model;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class JugadorController implements Controller {

	@Override
	public void agregarHandler(Model pmodel, DAO pdao) throws ClassNotFoundException, SQLException, RuletaException {
		//realia todas las validaciones.
		//1- los tres campos deben estar llenos.
		//2- Que el Alias no sea repetido.
		//3- El codigo debe estar en 0.
		
		
		Jugador jugador = (Jugador)pmodel;
		if(JugadorCRUDValidator.getErroresAlAgregar(jugador).isEmpty())		
			pdao.agregar(jugador);
		else
			throw new RuletaException("Se produjo un error :" + JugadorCRUDValidator.getErroresAlAgregar(jugador));

	}

	@Override
	public void modificarHandler(Model pmodel, DAO pdao) throws RuletaException, ClassNotFoundException, SQLException {
		
		Jugador jugador = (Jugador)pmodel;
		
		if(JugadorCRUDValidator.getErroresAlModificar(jugador).isEmpty())
			pdao.modificar(jugador);
		else
			throw new RuletaException("Se produjo un error:" + JugadorCRUDValidator.getErroresAlModificar(jugador));
	}

	@Override
	public void eliminarHandler(Model pmodel, DAO pdao) throws ClassNotFoundException, SQLException, RuletaException {
		
		Jugador jugador = (Jugador)pmodel;
		
		if(JugadorCRUDValidator.getErroresAlEliminar(jugador).isEmpty())
			pdao.eliminar(jugador);
		else
			throw new RuletaException("Se produjo un error:" + JugadorCRUDValidator.getErroresAlEliminar(jugador));
	}

	@Override
	public List leernarHandler(Model pmodel, DAO pdao) throws ClassNotFoundException, SQLException, RuletaException{
		//no valida nada 
		return pdao.leer(pmodel);
		
	}

}
