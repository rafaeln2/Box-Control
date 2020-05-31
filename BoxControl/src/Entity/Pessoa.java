package Entity;

import java.util.ArrayList;
import java.util.List;


public class Pessoa {

	private Integer idPessoa;
	private String cpf;
	private String nome;
	private String dataNasc;
	
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public Pessoa() {
	}

	public Pessoa(String cpf, String nome, String date) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = date;
		this.pessoas.add(this);
	}

	public Pessoa(Integer idPessoa, String cpf, String nome, String date) {
		this.idPessoa = idPessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = date;
		this.pessoas.add(this);
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public Pessoa setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
		return this;
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
		return "\n Pessoa [id_pessoa= " + idPessoa + ", cpf= " + cpf + ", nome= " + nome + ", dataNasc= " + dataNasc + "]";
	}
	
	
}
