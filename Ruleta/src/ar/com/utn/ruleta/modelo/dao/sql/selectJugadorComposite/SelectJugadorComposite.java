package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.SelectJugadorStrategy;

public abstract class SelectJugadorComposite{

			
	protected static Jugador jugador;
	protected static int equalsLike;
	
	
	//private static List<SelectJugadorComposite> campos= new ArrayList<SelectJugadorComposite>();
	
	public SelectJugadorComposite() {}
	

	public  static String getSql(Jugador pJug, int pEqualike){
		jugador = pJug;
		equalsLike=pEqualike;
		
		List<SelectJugadorComposite> campos= new ArrayList<SelectJugadorComposite>();
	
		campos.add(new SelectNombreJugadorComposite());
		campos.add(new SelectApellidoJugadorComposite());
		campos.add(new SelectAliasJugadorComposite());
		
		StringBuffer sql = new StringBuffer("select jug_id, jug_nombre, jug_apellido, jug_alias from ruleta.jugadores where ");
		
		for (SelectJugadorComposite campo : campos) 
			if(!campo.isEmpty())
				sql.append(campo.getEqualsLikeSql());

		return  sql.toString().substring(0,sql.toString().length()-4).trim();
}
	
	public abstract boolean isEmpty();
	public abstract String getEqualsLikeSql();
	
	
}
