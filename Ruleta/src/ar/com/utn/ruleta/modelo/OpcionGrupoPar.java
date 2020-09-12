package ar.com.utn.ruleta.modelo;

public class OpcionGrupoPar extends OpcionGrupo{

	public OpcionGrupoPar (){       }
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.PAR ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isPar() ;
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
		
		return "Par";
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.PAR;
	}

	
	
}
