package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

/**
 *  Gabriel
 * Esta clase tiene la finalidad de alojar un numero
 * y todos los metod
 */
public class Numero implements Model{
	private int valor;
	//constructores
	public Numero(){
		valor=0;
	}
	public Numero(int pValor) throws RuletaException{
		setValor(pValor);		
	}
	/**
	 * Este metodo asigna un  valor al numero atraves del parametros  pValor 
	 * @param pValor
	 */
	public void setValor(int pValor) throws RuletaException{
		if(pValor<0 || pValor>36)
			throw new RuletaException();
		valor = pValor;
	}
	public int getValor(){
		return valor;
	}
	//metodos de negocio
	public boolean isRojo(){
		List<Integer> numerosRojos = new ArrayList<Integer>();
		//cargo del 1 al 9 lo impares
		for(int i=1;i<10; i= i + 2)
			numerosRojos.add(new Integer(i) );
		
		//cargo pares del 14 al 18
		for (int i=12;i<19; i +=2)
			numerosRojos.add(new Integer(i) );
		
		//desde el 19 al 27
		for (int i=19;i<28; i +=2)
			numerosRojos.add(new Integer(i) );
		//desde el 30 al 36

		for (int i=30;i<37; i +=2)
			numerosRojos.add(new Integer(i) );
		
		return numerosRojos.contains(new Integer(valor));
	}
	
	public boolean isNegro(){
		return !isRojo() &&
			   valor >0;
	}
	public boolean isPar(){
		//mod by gcasas
		return valor%2==0 &&
				valor >0;
	}
	
	public boolean isImpar(){
		//agregado by gcasas
		return valor%2==1;
	}
	
	public boolean isPrimeraDocena(){
		//agregado by gcasas
		return valor>0 && valor<13;
	}
	public boolean  isSegundaDocena(){
		//agregado by gcasas
		return valor>13 && valor<25;
	}
	public boolean isTercerDocena(){
		//agregado by gcasas
		return valor>25 && valor<37;
	}
	public boolean isPrimeraColumna(){
		//agregado by gcasas
		boolean bln=false;
		int i =1;
		
		while(i<37 && !bln){
			bln=i==valor;
			i+=3;
		}
			
		return bln;
	}
	
	public boolean isSegundaColumna(){
		//agregado by gcasas
		boolean bln=false;
		int i =2;
		
		while(i<37 && !bln){
			bln=i==valor;
			i+=3;
		}
			
		return bln;
	}
	public boolean isTercerColumna(){
		//agregado by gcasas
		boolean bln=false;
		int i =3;
		
		while(i<37 && !bln){
			bln=i==valor;
			i+=3;
		}
			
		return bln;
	}
	public boolean isFrom1To18(){
		//agregado by gcasas
		return valor>0 && valor<19;
	}
	public boolean isFrom19To36(){
		//agregado by gcasas
		return valor>18 && valor<37;
	}
	public boolean isCero(){
		return false;
	}
	
	public boolean equals(Object obj){

		return obj instanceof Numero &&
				obj!=null 			 &&
			   ((Numero)obj).getValor() == valor;
	}
	public int hashCode(){
		return valor;
	}
    public String toString(){
    	//mod by gcasas
    	StringBuffer sb = new StringBuffer("valor=");
    	sb.append(valor);
    	sb.append("\n");
    	return sb.toString();
    }
	@Override
	public boolean isVacio() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
