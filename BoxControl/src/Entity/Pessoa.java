package Entity;

import java.sql.Date;

public class Pessoa {

	private Integer idPessoa;
	private String cpf;
	private String nome;
	private Date dataNasc;
	
	public Pessoa() {
	}

	public Integer getId_pessoa() {
		return idPessoa;
	}

	public void setId_pessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
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
		return "Pessoa [id_pessoa=" + idPessoa + ", cpf=" + cpf + ", nome=" + nome + ", data_nasc=" + dataNasc + "]";
	}
	
	
}
