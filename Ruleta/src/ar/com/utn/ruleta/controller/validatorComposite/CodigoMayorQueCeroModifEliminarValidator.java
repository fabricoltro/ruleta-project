package ar.com.utn.ruleta.controller.validatorComposite;

import java.sql.SQLException;

public class CodigoMayorQueCeroModifEliminarValidator extends JugadorCRUDValidator {

	@Override
	public boolean verificarError() throws ClassNotFoundException, SQLException {
		
		return jugador.getCodigo()==0;
	}

	@Override
	public String getError() {
		return "El codigo debe ser mayor que 0(cero)" ;
	}

	
	
	
	
}
