package ar.com.utn.ruleta.controller.validatorComposite;

public class CodigoDebeSerCeroJugAgrValidator extends JugadorCRUDValidator {

	@Override
	public boolean verificarError() {		
		return jugador.getCodigo()>0;
	}

	@Override
	public String getError() {		
		return "El codigo debe ser 0(cero)";
	}

}
