package Entity;

import java.util.ArrayList;

public class Pessoa {

	private Integer cdPessoa;
	private String cpf;
	private String nome;
	private String dataNasc;
	
	public Pessoa() {
	}

	public Pessoa(String cpf, String nome, String date) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = date;
	}

	public Pessoa(Integer cdPessoa, String cpf, String nome, String date) {
		this.cdPessoa = cdPessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = date;
	}

	public Integer getcdPessoa() {
		return cdPessoa;
	}

	public Pessoa setcdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
		return this;
	}
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

	public Pessoa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String date) {
		this.dataNasc = date;
	}
	@Override
	public String toString() {
		return "\n Pessoa [id_pessoa= " + cdPessoa + ", cpf= " + cpf + ", nome= " + nome + ", dataNasc= " + dataNasc + "]";
	}
	
	
}
