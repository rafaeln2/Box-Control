package RelatorioEntity;

public class RelatorioEstoqueEntity {
	private int cdProduto;
	private String nomeProduto;
	private int quantidadeProduto;

	public RelatorioEstoqueEntity(int cdProduto, String nomeProduto, int quantidadeProduto) {
		super();
		this.cdProduto = cdProduto;
		this.nomeProduto = nomeProduto;
		this.quantidadeProduto = quantidadeProduto;
	}

	public int getCdProduto() {
		return cdProduto;
	}
	
	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@Override
	public String toString() {
		return "EstoqueEntityView [cdProduto=" + cdProduto + ", nomeProduto=" + nomeProduto + ", quantidadeProduto="
				+ quantidadeProduto + "]";
	}

}
