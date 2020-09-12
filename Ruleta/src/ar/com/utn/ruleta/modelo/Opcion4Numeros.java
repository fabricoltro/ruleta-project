package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;
import ar.com.utn.ruleta.modelo.Numero;


import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion4Numeros extends Opcion {
	//mod by gcasas
	private int 			codigo	;
	private List<Numero> 	numeros	= new ArrayList<Numero>();
	
	
	//constructores
	
	public Opcion4Numeros(int saldo) {				super(saldo);		}
	public Opcion4Numeros(List<Numero> pNumeros) {	numeros = pNumeros;	}	
	public Opcion4Numeros(int ncod, List<Numero> lNum){
		codigo = ncod;
		numeros = lNum;
	}
	
	public Opcion4Numeros(int pCod, List<Numero> lNum, int pSaldo){
		this(pCod, lNum);
		setSaldo(pSaldo);
	}

	public Opcion4Numeros(int pCod, int pPriNum, int pSegNum, int pTerNum, int pCuaNum, int pSaldo) throws RuletaException{
		numeros.add(new Numero(pPriNum));
		numeros.add(new Numero(pSegNum));
		numeros.add(new Numero(pTerNum));
		numeros.add(new Numero(pCuaNum));
		codigo=pCod;
		setSaldo(pSaldo);
	}

	//getter y setter

	public int getCodigo() {						return codigo;			}
	public void setCodigo(int ncod){				this.codigo = ncod;		}

	public List<Numero> getNumeros() {				return numeros;			}
	public void setNumeros(List<Numero> pNumeros) throws RuletaException{
		//1-este metodo va a recibir 4 numeros
		//2-los numeros tienen que ser los abarque la ficha.
		//si esta todo bien
		// 0 1 2 3 posicion
 		// 1 2 4 5 valores
		boolean bln = false;
		bln = 	pNumeros.get(0).getValor()+1 == pNumeros.get(1).getValor() && // 1+1= 2
				pNumeros.get(2).getValor()+1 == pNumeros.get(3).getValor() && // 4+1= 5
				pNumeros.get(1).getValor()+2 == pNumeros.get(2).getValor() ;  // 2+2= 4  	
		if(bln)
			numeros = pNumeros;
		else
			throw new RuletaException("Lita de 4 numeros erronea");
	}

	//metodos de negocio

	@Override
	public int cobrar() {
		return getSaldo()*9;
	}

	@Override
	public boolean validar(Numero pNum) {		
		return numeros.contains(pNum);
	}

	@Override
	public String getValores() {
		StringBuffer  sb = new StringBuffer();
		for (Numero numero : numeros) {
			sb.append(numero.getValor());
			sb.append("-");
		}
		return sb.substring(0, sb.length()-1).toString();
	}
	
	public void addNUmero(Numero numero) {
		//agreg by gcasas
		numeros.add(numero);
		
	}
	public boolean isVacio() {		
		return this.codigo==0 							&&
				(this.numeros==null || numeros.isEmpty() );
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Opcion4Numeros)) {
			return false;
		}
		Opcion4Numeros other = (Opcion4Numeros) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return super.toString() + "\ncodigo=" + codigo + "\nnumeros=" + numeros;
	}
	
}
















