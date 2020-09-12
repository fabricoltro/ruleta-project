package ar.com.utn.ruleta.modelo;

public class ruleta {

	public int tirarBola(){
		return (int)(Math.random()*1000)%37;
	}
}
