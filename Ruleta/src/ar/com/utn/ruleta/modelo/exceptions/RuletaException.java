package ar.com.utn.ruleta.modelo.exceptions;

public class RuletaException extends Exception {

	public RuletaException() {
		super("El numero no esta en el rango 0 - 36");
		
	}

	public RuletaException(String arg0) {
		super(arg0);
	}
	

}
