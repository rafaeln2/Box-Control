package Entity;

public class Endereco {
	
	private int cdEndereco;
	private String rua;
	private String nuEndereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private int cdPessoa;


	public Endereco(String rua, String nuEndereco, String bairro, String cidade, String estado, String cep,
			int cdPessoa) {
		super();
		this.rua = rua;
		this.nuEndereco = nuEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.cdPessoa = cdPessoa;
	}

	public int getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(int cdEndereco) {
		this.cdEndereco = cdEndereco;
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

	public int getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + cdEndereco + ", rua=" + rua + ", nuEndereco=" + nuEndereco + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", cdPessoa=" + cdPessoa
				+ "]";
	}
	
	
}
