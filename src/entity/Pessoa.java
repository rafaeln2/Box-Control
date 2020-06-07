package entity;

public class Pessoa {
	
	private int cdProduto;
	private String cpf;
	private String nome;
	private String dataNascimento;
	
	public Pessoa(int cdProduto, String cpf, String nome, String dataNascimento) {
		super();
		this.cdProduto = cdProduto;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public int getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return "Pessoa [cdProduto=" + cdProduto + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
