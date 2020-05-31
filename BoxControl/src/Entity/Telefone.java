package Entity;

public class Telefone {

	private Integer cdTelefone;
	private String ddd;
	private String numero;
	private Integer cdPessoa; //enum

	public Telefone() {
	}


	public Integer getCdTelefone() {
		return cdTelefone;
	}


	public void setCdTelefone(Integer cdTelefone) {
		this.cdTelefone = cdTelefone;
	}


	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Integer getCdPessoa() {
		return cdPessoa;
	}


	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}


	@Override
	public String toString() {
		return "Telefone [idTelefone=" + cdTelefone + ", ddd=" + ddd + ", numero=" + numero + ", idPessoa=" + cdPessoa
				+ "]";
	}


}

