package ar.com.utn.ruleta.modelo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class NumeroTestMio {

	/**
	 * @param args
	 * @throws RuletaException 
	 */
	public static void main(String[] args) throws RuletaException {
		List<Numero> numeros = new ArrayList<Numero>();
		numeros.add(new Numero());
		numeros.add(new Numero(1));
		numeros.add(new Numero(2));
		numeros.add(new Numero(3));
		numeros.add(new Numero(1));
		numeros.add(new Numero(1));
		numeros.add(new Numero(2));
		System.out.println("list");
		System.out.println(numeros);
		
		Set<Numero> setNumeros = new HashSet<Numero>();
		
		setNumeros.add(new Numero());
		setNumeros.add(new Numero(1));
		setNumeros.add(new Numero(2));
		setNumeros.add(new Numero(3));
		setNumeros.add(new Numero(1));
		setNumeros.add(new Numero(1));
		setNumeros.add(new Numero(2));
		System.out.println("\n\nset");
		System.out.println(setNumeros);
	}

}





