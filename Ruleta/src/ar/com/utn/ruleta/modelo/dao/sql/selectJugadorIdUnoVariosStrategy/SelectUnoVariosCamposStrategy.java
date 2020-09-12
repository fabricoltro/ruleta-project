package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite.SelectJugadorComposite;

public class SelectUnoVariosCamposStrategy extends SelectJugadorStrategy {

	public SelectUnoVariosCamposStrategy() {}

	@Override
	public String getSql() {		
		return SelectJugadorComposite.getSql(jugador, equalsLike);
	}

	@Override
	public boolean validar() {		
		return jugador!=null && !jugador.isVacio();
	}

}
