package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

/**
 * @author Matias
 * Fecha: 06/06/2020
 * 
 * Esta clase contiene todos los datos del jugador
 * 
 */

public class Jugador implements Model{
	//atributos
	private int 			codigo								;
	private String 			nombre								;
	private String  		apellido							;
	private String  		alias								;
	//mod by gcasas se le agrego el atributo monto
	private int 			monto								;
	private List<Apuesta> 	apuestas = new ArrayList<Apuesta>()	;
	
	//getter y setter, equals nombre y apellido hascode toString Y DAO
	
	//Constructores
	public Jugador() {
		// se agregó el tema de poner los valores por defecto
		codigo 		= 0		;
		nombre 		= ""	;
		apellido 	= ""	;
		alias  		= ""	;
		monto 		= 0 	;
		apuestas	=null	;
	}
	
	public Jugador (String nomb, String apell, String al) {
		nombre 		= nomb	;
		apellido 	= apell	;
		alias 		= al	;
	}

	public Jugador(int cod, String nomb, String apell, String al) {
		codigo 		= cod	;
		nombre 		= nomb	;
		apellido 	= apell	;
		alias 		= al	;		
	}
	
	public Jugador(int cod, String nomb, String apell, String al, int pMonto) {
		codigo 		= cod	;
		nombre 		= nomb	;
		apellido 	= apell	;
		alias 		= al	;
		monto 		= pMonto;
	}
	
	//Getters y Setters
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nomb) {this.nombre = nomb;}
	
	public String getApellido() {return apellido;}
	public void setApellido(String apell) {this.apellido = apell;}
	
	public String getAlias() {return alias;}
	public void setAlias(String al) {this.alias = al;}
	
	
	public int getMonto() {					return monto;			}
	public void setMonto(int pMonto) {		this.monto = pMonto;	}

		
	public List<Apuesta> getApuestas() {					return apuestas;			}
	public void setApuestas(List<Apuesta> pApuestas) {		this.apuestas = pApuestas;	}

	public void addApuesta (Apuesta pApuesta){
		pApuesta.setJugador(this);
		apuestas.add(pApuesta);
	}
	public void acreditar(int pValor){
		monto+=pValor;
	}
	public void debitar(int pValor) throws RuletaException{
		if(pValor>monto)
			throw new RuletaException("saldo insuficiente");
		else
			monto-=pValor;
		
	}
	//Equals
	public boolean equalsNombre(Object obj) {
		if(obj instanceof Jugador && ((Jugador) obj).getNombre().equals(nombre)) {
			return true;
		}
		return false;
	}
	
	//hashcode
	public int hashCode() {
		return apellido.hashCode();
	}
	
	//toString
	public String toString() {
		StringBuilder sb = new StringBuilder("codigo=");
		sb.append(codigo);
		sb.append(",nombre=");
		sb.append(nombre);
		sb.append(",apellido=");
		sb.append(apellido);
		sb.append(",alias=");
		sb.append(alias);
		sb.append(",monto=");
		sb.append(monto);
		return sb.toString();
	}
	
	public boolean isVacio() {
		return codigo<=0 						&& 
		(nombre==null || nombre.isEmpty()) 		&&
		(apellido==null || apellido.isEmpty()) 	&& 
		(alias==null || alias.isEmpty())		&&
		monto==0								;												
		}
}
