package Entity;

public class Cargo {

	private int cdCargo = 0;
	private int nivelAcesso;
	private String nmCargo;
	
	public Cargo(int nivelAcesso, String nmCargo) {
		this.nivelAcesso = nivelAcesso;
		this.nmCargo = nmCargo;
	}

	public int getCdCargo() {
		return cdCargo;
	}

	public void setCdCargo(int cdCargo) {
		this.cdCargo = cdCargo;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getNmCargo() {
		return nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}
	
	@Override
	public String toString() {
		return "\nCargo [cdCargo=" + cdCargo + ", nivelAcesso=" + nivelAcesso + ", nmCargo=" + nmCargo + "]";
	}


}
