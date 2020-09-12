package ar.com.utn.ruleta.modelo;

public class OpcionGrupoTercerColumna extends OpcionGrupo {

	public OpcionGrupoTercerColumna() {	}

	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == TERCERCOLUMNA;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isTercerColumna();
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
		return "tercer columna";
	}

	@Override
	public int getGrupoConst() {
		return OpcionGrupo.TERCERCOLUMNA;
	}

}
