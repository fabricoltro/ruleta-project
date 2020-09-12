package ar.com.utn.ruleta.modelo;

public class OpcionGrupoTercerDocena extends OpcionGrupo{

	public OpcionGrupoTercerDocena () {}  
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.TERCERADOCENA ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isTercerDocena() ;
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
		return "tercer docena";
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.TERCERADOCENA;
	}
	

}
