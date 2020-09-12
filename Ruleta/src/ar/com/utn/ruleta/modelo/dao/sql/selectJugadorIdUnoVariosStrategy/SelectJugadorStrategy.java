package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Jugador;

public abstract class SelectJugadorStrategy {


	public SelectJugadorStrategy() {}
	
	protected static Jugador jugador;
	protected static int equalsLike;
	
	public static SelectJugadorStrategy  getInstance(Jugador pJug, int pEqualike){
		jugador = pJug;
		equalsLike = pEqualike;
		List<SelectJugadorStrategy> unoVariosStrategies = new ArrayList<SelectJugadorStrategy>();
		//aca estan todas las estrategias 
		
		unoVariosStrategies.add(new SelectVacioStrategy());
		unoVariosStrategies.add(new SelectIdStrategy());
		//Este es el que usa un CompoSite
		unoVariosStrategies.add(new SelectUnoVariosCamposStrategy());
		
		for (SelectJugadorStrategy selectVacioIdUnoVariosStrategy : unoVariosStrategies) 
			if(selectVacioIdUnoVariosStrategy.validar())
				return selectVacioIdUnoVariosStrategy;
		
		return null;
	}

	public abstract  String getSql();
	public abstract boolean validar();

	
}