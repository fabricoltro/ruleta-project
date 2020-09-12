package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.SelectJugadorStrategy;
import ar.com.utn.ruleta.modelo.dao.util.SqlConstant;

public class SelectNombreJugadorComposite  extends SelectJugadorComposite{
	
		
	public SelectNombreJugadorComposite() {}

	@Override
	public boolean isEmpty() {		
		return jugador.getNombre()==null ||
			   jugador.getNombre().isEmpty();
	}

	@Override
	public String getEqualsLikeSql() {
		StringBuffer sql = new StringBuffer("jug_nombre ");
		
		if(this.equalsLike == SqlConstant.EQUALS){
			sql.append("='");
			sql.append(jugador.getNombre());
			sql.append("' and ");
		}
			
		else if (this.equalsLike == SqlConstant.LIKE){
			sql.append("like '%");
			sql.append(jugador.getNombre());
			sql.append("%' and ");			
		}
		
		return sql.toString();
	}



	
		
}
