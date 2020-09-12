package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy;

import ar.com.utn.ruleta.modelo.Jugador;

public class SelectIdStrategy extends SelectJugadorStrategy{

	public SelectIdStrategy() {}

	@Override
	public String getSql() {
		StringBuffer 	sql = new StringBuffer("select jug_id, jug_nombre, jug_apellido, jug_alias ");
						sql.append("from ruleta.jugadores where jug_id=");
						sql.append(jugador.getCodigo());
		
		return sql.toString();
	}

	@Override
	public boolean validar() {		
		return jugador!=null && jugador.getCodigo()>0;
	}

}
