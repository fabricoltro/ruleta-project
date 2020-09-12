package ar.com.utn.ruleta.modelo;

public class DosNumeros {
	private int codigo;
	private int valor1;
	private int valor2;
	public DosNumeros() {super();}
	public DosNumeros(int codigo, int valor1, int valor2) {
		super();
		this.codigo = codigo;
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	
	public DosNumeros(int valor1, int valor2) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	public int getCodigo() {				return codigo;			}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}
	
	public int getValor1() {				return valor1;			}
	public void setValor1(int valor1) {		this.valor1 = valor1;	}
	
	public int getValor2() {				return valor2;			}
	public void setValor2(int valor2) {		this.valor2 = valor2;	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("codigo=");
		sb.append(codigo);
		sb.append(",valor1=");
		sb.append(valor1);
		sb.append(",valor2=");
		sb.append(valor2);
		sb.append("\n");
		return sb.toString();
	}
	

}
