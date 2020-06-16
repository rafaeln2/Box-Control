package RelatorioEntity;

public class RelatorioVendaEntity {
	
	private String nome;
	private String data;
	private String descr;
	private int quantidade;
	
	public RelatorioVendaEntity(String nome, String data, String descr, int quantidade) {
		super();
		this.nome = nome;
		this.data = data;
		this.descr = descr;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "RelatorioVendaEntity [nome=" + nome + ", data=" + data + ", descr=" + descr + ", quantidade="
				+ quantidade + "]";
	}	
	
}
