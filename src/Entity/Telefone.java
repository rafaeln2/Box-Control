package Entity;

public class Telefone {

	private int cdTelefone;
	private String tipoTelefone; 
	private String ddd;
	private String numero;
	private int cdPessoa;

	public Telefone(String tipoTelefone, String ddd, String numero, int cdPessoa) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.cdPessoa = cdPessoa;
	}
	
	public int getCdTelefone() {
		return cdTelefone;
	}
	public void setCdTelefone(int cdTelefone) {
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
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	@Override
	public String toString() {
		return "Telefone [cdTelefone=" + cdTelefone + ", tipoTelefone=" + tipoTelefone + ", ddd=" + ddd + ", numero="
				+ numero + ", cdPessoa=" + cdPessoa + "]";
	} 


}

