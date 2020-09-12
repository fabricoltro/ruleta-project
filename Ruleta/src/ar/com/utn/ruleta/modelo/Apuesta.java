package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Apuesta implements Model {
	
	private int 			codigo								;
	private List<Opcion> 	opciones= new ArrayList<Opcion>()	;
	private Numero 			numeroGanador						;
	private Jugador 		jugador	 							;
	
	public Apuesta() {}

	public Apuesta(int codigo, List<Opcion> opciones, Numero numeroGanador, Jugador jugador) {
		super()								;
		
		this.codigo 		= codigo		;
		this.opciones 		= opciones		;
		this.numeroGanador 	= numeroGanador	;
		this.jugador 		= jugador		;
		
	}

	public List<Opcion> getOpciones() {return opciones;}
	
	public void addOpcion(Opcion pOpcion) throws RuletaException{
		jugador.debitar(pOpcion.getSaldo());
		opciones.add(pOpcion);
	}
	
	public Numero getNumeroGanador() {return numeroGanador;}
	public void setNumeroGanador(Numero pNumeroGanador) {
		this.numeroGanador = pNumeroGanador;
		for (Opcion opcion : opciones) {
			if(opcion.validar(numeroGanador))
				jugador.acreditar(opcion.cobrar());
		}
	}
	
	public Jugador getJugador() {return jugador;}
	public void setJugador(Jugador jugador) {this.jugador = jugador;}

	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	@Override
	public boolean isVacio() {
		return codigo == 0 		&&
				opciones ==null &&
				jugador ==null 		;
	}
	
}
