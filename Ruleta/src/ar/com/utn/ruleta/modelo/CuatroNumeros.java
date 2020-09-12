package ar.com.utn.ruleta.modelo;

public class CuatroNumeros {
	private int codigo;
	private int valor1;
	private int valor2;
	private int valor3;
	private int valor4;
	
	public CuatroNumeros() {super();	}

	
	
	public CuatroNumeros(int codigo, int valor1, int valor2, int valor3, int valor4) {
		super();
		this.codigo = codigo;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
	}
	
	public CuatroNumeros(int valor1, int valor2, int valor3, int valor4) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
	}

	
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}
	
	public int getValor1() {		return valor1;	}
	public void setValor1(int valor1) {		this.valor1 = valor1;	}
	
	public int getValor2() {		return valor2;	}
	public void setValor2(int valor2) {		this.valor2 = valor2;	}
	
	public int getValor3() {		return valor3;	}
	public void setValor3(int valor3) {		this.valor3 = valor3;	}

	public int getValor4() {		return valor4;	}
	public void setValor4(int valor4) {		this.valor4 = valor4;	}

	public String toString(){
		StringBuffer sb = new StringBuffer("codigo=");
		sb.append(codigo);
		sb.append(",valor1=");
		sb.append(valor1);
		sb.append(",valor2=");
		sb.append(valor2);
		sb.append(",\nvalor3=");
		sb.append(valor3);
		sb.append(",valor4=");
		sb.append(valor4);		
		sb.append("\n\n");
		return sb.toString();
	}
	

}
