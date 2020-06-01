package Entity;

import java.sql.Date;

public class Pessoa {

	private Integer cdPessoa;
	private String cpf;
	private String nome;
	private Date dataNasc;
	
	public Pessoa() {
	}

	public Pessoa(String cpf, String nome, Date dataNasc) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}

	public Pessoa(Integer cdPessoa, String cpf, String nome, Date dataNasc) {
		super();
		this.cdPessoa = cdPessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}

	public Integer getcdPessoa() {
		return cdPessoa;
	}

	public void setcdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
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

	public Date getData_nasc() {
		return dataNasc;
	}

	public void setData_nasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Pessoa [id_pessoa=" + cdPessoa + ", cpf=" + cpf + ", nome=" + nome + ", data_nasc=" + dataNasc + "]";
	}
	
	
}
