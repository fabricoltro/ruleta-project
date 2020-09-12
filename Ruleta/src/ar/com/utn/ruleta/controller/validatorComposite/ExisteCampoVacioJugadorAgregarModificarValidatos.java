package ar.com.utn.ruleta.controller.validatorComposite;

public class ExisteCampoVacioJugadorAgregarModificarValidatos extends JugadorCRUDValidator {

	@Override
	public boolean verificarError() {
		
		return jugador == null 				||
				jugador.getNombre()== null 	||
				jugador.getNombre().isEmpty() ||
				jugador.getApellido() ==null ||
				jugador.getApellido().isEmpty() ||
				jugador.getAlias()==null ||
				jugador.getAlias().isEmpty();
	}

	@Override
	public String getError() {		
		return "El nombre, el apellido o el Alias estan vacios";
	}

}
