package Entity;

public class Cargo {

	private Integer cdCargo;
	private Integer nivelAcesso;
	private String nmCargo;

	public Cargo() {

	}

	public Integer getCdCargo() {
		return cdCargo;
	}

	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
	}

	public Integer getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Integer nivelAcesso) {
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
		return "Cargo [cdCargo=" + cdCargo + ", nivelAcesso=" + nivelAcesso + ", nmCargo=" + nmCargo + "]";
	}


}
