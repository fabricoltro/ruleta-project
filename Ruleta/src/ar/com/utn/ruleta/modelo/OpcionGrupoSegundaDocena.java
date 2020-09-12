package ar.com.utn.ruleta.modelo;

public class OpcionGrupoSegundaDocena extends OpcionGrupo{

	public OpcionGrupoSegundaDocena () {     } ;
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.SEGUNDADOCENA ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isSegundaDocena() ;
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
		return "segunda docena";
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.SEGUNDADOCENA;
	}

}
