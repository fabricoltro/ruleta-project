package ar.com.utn.ruleta.modelo;

public class OpcionGrupoNegro extends OpcionGrupo {

	public OpcionGrupoNegro() {}
	
	public  OpcionGrupoNegro(int pSaldo, Apuesta pApuesta) {
		super(pSaldo,pApuesta);
	}

	@Override
	public boolean validarGrupo(int pCodGrupo) {		
		return pCodGrupo == this.NEGRO;
	}

	@Override
	public boolean validar(Numero pNum) {		
		return pNum.isNegro();
	}

	@Override
	public int cobrar() {		
		return this.getSaldo()*2;
	}
	@Override
	public boolean isVacio() {
		return false;
	}

	@Override
	public String getValores() {
		return "NEGRO";
	}

	@Override
	public int getGrupoConst() {
		return OpcionGrupo.NEGRO;
	}


}
