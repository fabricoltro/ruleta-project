package ar.com.utn.ruleta.modelo;

public class OpcionGrupoPrimerColumna extends OpcionGrupo {

	public OpcionGrupoPrimerColumna() {	}

	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo==PRIMERCOLUMNA;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isPrimeraColumna();
	}

	@Override
	public int cobrar() {
		return getSaldo()*3;
	}
	@Override
	public boolean isVacio() {
		return false;
	}
	@Override
	public String getValores() {
		return "primer columna";
	}

	@Override
	public int getGrupoConst() {
		return OpcionGrupo.PRIMERCOLUMNA;
	}
	
}
