package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite;

import ar.com.utn.ruleta.modelo.dao.util.SqlConstant;

public class SelectApellidoJugadorComposite extends SelectJugadorComposite {

	public SelectApellidoJugadorComposite() {}

	@Override
	public boolean isEmpty() {
		return jugador.getApellido()==null||
			   jugador.getApellido().isEmpty();
	}

	@Override
	public String getEqualsLikeSql() {
	StringBuffer sql = new StringBuffer("jug_apellido ");
		
		if(this.equalsLike == SqlConstant.EQUALS){
			sql.append("='");
			sql.append(jugador.getApellido());
			sql.append("' and ");
		}
			
		else if (this.equalsLike == SqlConstant.LIKE){
			sql.append("like '%");
			sql.append(jugador.getApellido());
			sql.append("%' and ");			
		}
		
		return sql.toString();
	}

}
