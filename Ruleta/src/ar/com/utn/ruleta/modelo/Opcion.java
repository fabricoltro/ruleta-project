package ar.com.utn.ruleta.modelo;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

/**
 * @author Gabriel
 * Esta clase define a todas las opciones que se van a utilizar en el juego de la ruleta
 * cuando nos referios a opciones nos estamos refiriento a los items de las apuestas, 
 * o se que que cada hijo de opcion va a ser un dato sobre una apuesta
 *
 */

public abstract class Opcion implements Model {
	//atributos
	private int 	saldo;
	private Apuesta apuesta;
	
	public Opcion() {}
	
	//constructores
	public Opcion( int pSaldo) {		
		super();	
		saldo =  pSaldo;
	}
	
	public Opcion(int pSaldo, Apuesta pApuesta) {
		super();
		this.saldo = pSaldo;
		this.apuesta = pApuesta;
	}

	//getter y setter
	public int getSaldo() {					return saldo;		}
	public void setSaldo(int saldo) {		this.saldo = saldo;	}

	public Apuesta getApuesta() {					return apuesta;			}
	public void setApuesta(Apuesta apuesta) {		this.apuesta = apuesta;	}
	
	
	//metodos de negocio
	
	
	/**
	 * Este metodo va a obliga a los hijos a identificar si el numero que salio en rulata corresponoe a esa opcion
	 * @param pNum es el numero que salio en la ruleta
	 * @return devuelve verdadero en el caso que el numero corresponde con la opcion elegida ya false en el caso contrario
	 */
	public abstract boolean validar(Numero pNum);
	
	/**
	 * Obliga a los hijos a determinar el monto o cuantas veces el saldo aposta
	 * @return devuelve un valor entero correspondiente al monto a cobrar
	 */
	public abstract int cobrar();
	
	/**
	 * Este metodo devuele los valores crudos que tiene la clase en cuestion o el texto que identifique el grupo
	 * en el caso de ser uno de ellos
	 * 
	 * @return
	 */
	public abstract String getValores();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + saldo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Opcion)) {
			return false;
		}
		Opcion other = (Opcion) obj;
		if (saldo != other.saldo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "\nsaldo=" + saldo + "\nApuesta=" + apuesta ;
	}
	
	
	
}
