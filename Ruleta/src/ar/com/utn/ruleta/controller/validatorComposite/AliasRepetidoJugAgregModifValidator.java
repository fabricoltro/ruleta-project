package ar.com.utn.ruleta.controller.validatorComposite;

import java.sql.SQLException;
import java.util.List;

import ar.com.utn.ruleta.dao.DAO;
import ar.com.utn.ruleta.dao.JugadorDao;
import ar.com.utn.ruleta.modelo.Jugador;

public class AliasRepetidoJugAgregModifValidator extends JugadorCRUDValidator {

	@Override
	public boolean verificarError() throws ClassNotFoundException, SQLException  {
		DAO jugadorDao = new JugadorDao();
		List jugadores = null;
		//mod by gcasas se creo un jugador solo con un alias
		Jugador jugSoloAlias = new Jugador("", "", jugador.getAlias());
		jugadores =jugadorDao.leer(jugSoloAlias);
		//mod by gcasas se verifico que la razon que traiga varios no este 
		//relacionado al criterio de obj nulo o vacio
		return jugadores.size()>0 		&&
				jugador != null 		&&
				!jugador.isVacio()		&&
				!jugSoloAlias.isVacio();
	}

	@Override
	public String getError() {
		
		return "El alias esta repetido";
	}

}
