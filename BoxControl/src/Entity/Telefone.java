package Entity;

public class Telefone {

	private Integer idTelefone;
	private String ddd;
	private String numero;
	private Integer idPessoa;

	public Telefone() {
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
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

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", ddd=" + ddd + ", numero=" + numero + ", idPessoa=" + idPessoa
				+ "]";
	}


}

