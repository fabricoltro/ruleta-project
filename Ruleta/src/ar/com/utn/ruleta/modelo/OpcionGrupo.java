package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

/**
 * @author Gabriel
 * Esta clase da las pautas que van a tener todas las opciones de tipo grupo, por lo tanto va a tener una apuesta
 * asociada 
 *
 */
public abstract class OpcionGrupo extends Opcion {
	//constantes
	public static final int NEGRO 			=100;
	public static final int ROJO 			=200;
	public static final int PAR 			=300;
	
	public static final int IMPAR 			=400;
	public static final int PRIMEADOCENA	=500;
	public static final int SEGUNDADOCENA	=600;
  
	public static final int TERCERADOCENA	=700;
	public static final int FROM1TO18 		=800;	
	public static final int FROM19TO36 		=900;	
	
	public static final int PRIMERCOLUMNA	=1000;
	public static final int SEGUNDACOLUMNA	=1100;
	public static final int TERCERCOLUMNA 	=1200;
	
	//constructores
	public OpcionGrupo() {}
	
	public OpcionGrupo(int pSaldo) {
		super(pSaldo);
	}
	public OpcionGrupo(int pSaldo, Apuesta pApuesta) {
		super(pSaldo, pApuesta);

	}


	//metodos de negocio
	/**
	 * Esta clase tiene la finalidad de devolver un objeto OpcionGrupo, responde al patrón Factory, por lo caul, esta metodo tiene conocimiento
	 * de todos sus hijos, pero solamente devuelve el que corresponde coresponde al codigo recibdo.
	 * @param pCodGrupo, coresponde al codigo del objeto grupo que quiero que se devuelva
	 * @return devuelve un objeto de tipo OpcionGrupo coincidente con algunas de las constantes definidas
	 */
	public static OpcionGrupo getInstance(int pCodGrupo){
				
		//Este metodo responde al paton factory com
		//para lo caul debe existir un hijo por cada una de las opciones por 
		List<OpcionGrupo> lstTodosLosGrupos = new ArrayList<OpcionGrupo>();
		lstTodosLosGrupos.add(new OpcionGrupoNegro());
		lstTodosLosGrupos.add(new OpcionGrupoRojo ());
		lstTodosLosGrupos.add(new OpcionGrupoPar ());
		lstTodosLosGrupos.add(new OpcionGrupoImpar ());
		lstTodosLosGrupos.add(new OpcionGrupoPrimerDocena ());
		lstTodosLosGrupos.add(new OpcionGrupoSegundaDocena ());
		lstTodosLosGrupos.add(new OpcionGrupoTercerDocena ());
		lstTodosLosGrupos.add(new OpcionGrupoFrom1to18 ());
		lstTodosLosGrupos.add(new OpcionGrupoFrom19to36 ());
		lstTodosLosGrupos.add(new OpcionGrupoPrimerColumna ());
		lstTodosLosGrupos.add(new OpcionGrupoSegundaColumna ());
		lstTodosLosGrupos.add(new OpcionGrupoTercerColumna ());
			
		for (OpcionGrupo opcionGrupo : lstTodosLosGrupos) {
			if(opcionGrupo.validarGrupo(pCodGrupo))
				return opcionGrupo;
			
		}
		return null;
	}
	


	/**
	 * Este metodo tine la finalida de determinar si el codigo recibido corresponde a la clase con la cual se esta validando
	 * de ser coincidente devuelve true y caso conrario devuelve false
	 * @param pCodGrupo corresponde al codigo del grupo para verificar coincidencia o no coincidencia con el grupo actual
	 * @return true si el pCodGrupo concide con este grupo y false.
	 */
	public abstract boolean validarGrupo(int pCodGrupo);
	
	/**
	 * Este método tiene la finalidad de obtener la contante que corresponde al grupo en cuestion
	 * @return devuelve un valor entero
	 */
	public abstract int getGrupoConst();

}
