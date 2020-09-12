package ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite;

import ar.com.utn.ruleta.modelo.dao.util.SqlConstant;

public class SelectAliasJugadorComposite extends SelectJugadorComposite {

	public SelectAliasJugadorComposite() {}

	@Override
	public boolean isEmpty() {
		return jugador.getAlias()==null||
			   jugador.getAlias().isEmpty();
	}

	@Override
	public String getEqualsLikeSql() {
	StringBuffer sql = new StringBuffer("jug_alias ");
		
		if(this.equalsLike == SqlConstant.EQUALS){
			sql.append("='");
			sql.append(jugador.getAlias());
			sql.append("' and ");
		}
			
		else if (this.equalsLike == SqlConstant.LIKE){
			sql.append("like '%");
			sql.append(jugador.getAlias());
			sql.append("%' and ");			
		}
		
		return sql.toString();
	}
}
