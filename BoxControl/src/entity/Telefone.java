package entity;

public class Telefone {

	private Integer cdTelefone;
	private String tipoTelefone; //enum
	private String ddd;
	private String numero;
	private Integer cdPessoa;
	public Telefone(Integer cdTelefone, String tipoTelefone, String ddd, String numero, Integer cdPessoa) {
		super();
		this.cdTelefone = cdTelefone;
		this.tipoTelefone = tipoTelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.cdPessoa = cdPessoa;
	}
	public Telefone(String tipoTelefone, String ddd, String numero, Integer cdPessoa) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.cdPessoa = cdPessoa;
	}
	public Integer getCdTelefone() {
		return cdTelefone;
	}
	public void setCdTelefone(Integer cdTelefone) {
		this.cdTelefone = cdTelefone;
	}
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
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
	public Integer getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	@Override
	public String toString() {
		return "Telefone [cdTelefone=" + cdTelefone + ", tipoTelefone=" + tipoTelefone + ", ddd=" + ddd + ", numero="
				+ numero + ", cdPessoa=" + cdPessoa + "]";
	} 


}

