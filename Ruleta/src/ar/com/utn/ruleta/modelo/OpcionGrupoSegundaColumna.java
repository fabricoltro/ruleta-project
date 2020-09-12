package ar.com.utn.ruleta.modelo;

public class OpcionGrupoSegundaColumna extends OpcionGrupo {

	public OpcionGrupoSegundaColumna() {}

	@Override
	public boolean validarGrupo(int pCodGrupo) {	
		return pCodGrupo== SEGUNDACOLUMNA;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isSegundaColumna();
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
		return "segunda columna";
	}

	@Override
	public int getGrupoConst() {
		return OpcionGrupo.SEGUNDACOLUMNA;
	}

}
