package ar.com.utn.ruleta.modelo;

public class OpcionGrupoFrom1to18 extends OpcionGrupo{

	public OpcionGrupoFrom1to18 () {}
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.FROM1TO18 ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isFrom1To18() ;
	}

	@Override
	public int cobrar() {
		return this.getSaldo()*2 ;
	}
	@Override
	public boolean isVacio() {
		return false;
	}
	@Override
	public String getValores() {
		return "1 a 18";
		
	}
	@Override
	public int getGrupoConst() {		
		return OpcionGrupo.FROM1TO18;
	}


}
