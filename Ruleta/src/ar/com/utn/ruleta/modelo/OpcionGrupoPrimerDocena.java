package ar.com.utn.ruleta.modelo;

public class OpcionGrupoPrimerDocena extends OpcionGrupo{

	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.PRIMEADOCENA ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isPrimeraDocena() ;
	}

	@Override
	public int cobrar() {
		return this.getSaldo()*3;
	}
	@Override
	public boolean isVacio() {
		return false;
	}

	@Override
	public String getValores() {
		return "PrimerDocena";
	}

	@Override
	public int getGrupoConst() {
		return OpcionGrupo.PRIMEADOCENA;
	}

}
