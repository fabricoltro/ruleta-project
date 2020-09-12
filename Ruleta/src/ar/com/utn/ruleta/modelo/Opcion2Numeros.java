package ar.com.utn.ruleta.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion2Numeros extends Opcion {
	//mod by gcsas
	
	private int codigo;
	private List<Numero> numeros= new ArrayList<Numero>();
	public Opcion2Numeros()							{}
	public Opcion2Numeros(int pCod) 				{		codigo=pCod;		}
	public Opcion2Numeros(List<Numero> pNumeros) 	{		numeros = pNumeros;	}
	
	public Opcion2Numeros(int pCod, List<Numero> pNros,int pSaldo, Apuesta pApu) {
		super(pSaldo, pApu);
		codigo=pCod;
		numeros=pNros;
	}
	
	public Opcion2Numeros(int pSaldo, List<Numero> lNum){
		super(pSaldo);
		numeros = lNum;
	}
	
	public Opcion2Numeros(int pSaldo, int pPrimerNum, int pSegNum) throws RuletaException{
		super(pSaldo);		
		numeros.add(new Numero(pPrimerNum));
		numeros.add(new Numero(pSegNum));
		
	}

	//getter anda setter
	
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	
	public List<Numero> getNumeros() {return numeros;}
	public void setNumeros(List<Numero> pNumeros) {this.numeros = pNumeros;}

	//metodos de negocio
	@Override
	public int cobrar() {return getSaldo()*18;}
	
	public void addNUmero(Numero  pNum){	
		numeros.add(pNum);
	}
	

	@Override
	public boolean validar(Numero pNum) {		
		return numeros.contains(pNum);
	}

	public boolean isVacio() {		
		return this.codigo==0 							&&
				(this.numeros==null || numeros.isEmpty() );
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
		if (!(obj instanceof Opcion2Numeros)) {
			return false;
		}
		Opcion2Numeros other = (Opcion2Numeros) obj;
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
