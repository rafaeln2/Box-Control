package Entity;

public class Endereco {
	
	private Integer idEndereco;
	private String rua;
	private String nuEndereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String idPessoa;
	
	public Endereco() {
		
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNuEndereco() {
		return nuEndereco;
	}

	public void setNuEndereco(String nuEndereco) {
		this.nuEndereco = nuEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", rua=" + rua + ", nuEndereco=" + nuEndereco + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", idPessoa=" + idPessoa
				+ "]";
	}
	
	
}
