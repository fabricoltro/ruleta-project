package ar.com.utn.ruleta.modelo;

public class OpcionGrupoFrom19to36 extends OpcionGrupo{

	public OpcionGrupoFrom19to36 () {}
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.FROM19TO36 ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isFrom19To36() ;
	}

	@Override
	public int cobrar() {
		return this.getSaldo()*3 ;
	}
	@Override
	public boolean isVacio() {
		return false;
	}
	@Override
	public String getValores() {		
		return "19 a 36";		
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.FROM19TO36;
	}
	

}
