package ar.com.utn.ruleta.modelo;

import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class Opcion1Numero extends Opcion {
	//mod by gcasas
	private int codigo;
	Numero numero;
	//constructor
	public Opcion1Numero(int saldo, Numero pNum) {
		super(saldo);
		numero = pNum;
	}
	
	public Opcion1Numero(int saldo, Numero pNum,Apuesta pApu,int aCod) {
		super(saldo,pApu );
		codigo = aCod;
		numero = pNum;
		
	}
	
	public Opcion1Numero(int saldo, Numero pNum,Apuesta pApu) {
		super(saldo, pApu);
		numero = pNum;
		
	}
	public Opcion1Numero(int acod) {
		codigo = acod;
	}
	
	//getter y setter
	public Numero getNumero() {					return numero;			}
	public void setNumero(Numero numero) {		this.numero = numero;	}

	public int getCodigo() {		return codigo;	}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}
	
	//metodos de negocio
	@Override
	public int cobrar() {		
		return getSaldo()*36;
	}
	@Override
	public boolean validar(Numero pNum) {		 
		return numero.equals(pNum);
	}
	@Override
	public String getValores() {
		StringBuffer sb =new StringBuffer();
		sb.append(numero.getValor());
		return sb.toString() ;
	}

	public boolean isVacio() {		
		return this.codigo==0 ;
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
		if (!(obj instanceof Opcion1Numero)) {
			return false;
		}
		Opcion1Numero other = (Opcion1Numero) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\ncodigo=" + codigo + "\nnumero=" + numero  ;
	}


	
}









