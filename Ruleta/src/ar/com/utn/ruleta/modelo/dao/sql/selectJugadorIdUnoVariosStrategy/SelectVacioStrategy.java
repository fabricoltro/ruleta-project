package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy;

import ar.com.utn.ruleta.modelo.Jugador;

public class SelectVacioStrategy extends SelectJugadorStrategy {

	public SelectVacioStrategy() {}

	@Override
	public String getSql() {
		
		return "select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores";
	}

	@Override
	public boolean validar() {		
		return jugador==null || jugador.isVacio();
	}

}
