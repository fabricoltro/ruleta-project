package ar.com.utn.ruleta.modelo;

public class OpcionGrupoImpar extends OpcionGrupo{

	public OpcionGrupoImpar (){     }
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.IMPAR ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isImpar () ;
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
		
		return "Impar";
		
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.IMPAR;
	}


}
