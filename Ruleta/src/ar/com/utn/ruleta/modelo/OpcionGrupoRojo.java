package ar.com.utn.ruleta.modelo;

public class OpcionGrupoRojo extends OpcionGrupo{

	public OpcionGrupoRojo() {}
	public OpcionGrupoRojo(int pSaldo) {
		setSaldo(pSaldo);
		
	}
	public OpcionGrupoRojo(int pSaldo, Apuesta pApuesta) {
		super(pSaldo,pApuesta);
	}
	@Override
	public boolean validarGrupo(int pCodGrupo) {
		return pCodGrupo == this.ROJO ;
	}

	@Override
	public boolean validar(Numero pNum) {
		return pNum.isRojo() ;
	}

	@Override
	public int cobrar() {
		return this.getSaldo()*2  ; 
	}
	@Override
	public boolean isVacio() {
		return false;
	}
	@Override
	public String getValores() {
		return "ROJO";
	}
	@Override
	public int getGrupoConst() {
		return OpcionGrupo.ROJO;
	}

	
}
