package entity;

public class Endereco {
	
	private Integer cdEndereco;
	private String rua;
	private String nuEndereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Integer cdPessoa;
	
	public Endereco() {
		
	}

	public Endereco(String rua, String nuEndereco, String bairro, String cidade, String estado, String cep,
			Integer cdPessoa) {
		super();
		this.rua = rua;
		this.nuEndereco = nuEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.cdPessoa = cdPessoa;
	}

	public Endereco(Integer cdEndereco, String rua, String nuEndereco, String bairro, String cidade, String estado,
			String cep, Integer cdPessoa) {
		super();
		this.cdEndereco = cdEndereco;
		this.rua = rua;
		this.nuEndereco = nuEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.cdPessoa = cdPessoa;
	}

	public Integer getIdEndereco() {
		return cdEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.cdEndereco = idEndereco;
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

	public Integer getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + cdEndereco + ", rua=" + rua + ", nuEndereco=" + nuEndereco + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", cdPessoa=" + cdPessoa
				+ "]";
	}
	
	
}
