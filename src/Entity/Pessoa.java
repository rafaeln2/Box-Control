package Entity;

public class Pessoa {
	
	protected String cpf;
	protected String nome;
	protected String dataNascimento;
	protected int cdPessoa = 0;

	public Pessoa(String cpf, String nome, String dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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
	
	public int getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [cdPesoa =" + cdPessoa + " cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
