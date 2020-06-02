package entity;

public class Estoque {

	private Integer cdEstoque;
	private Integer cdProduto;
	private Integer quantidade;

	public Estoque() {

	}
	

	public Estoque(Integer cdProduto, Integer quantidade) {
		super();
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
	}


	public Estoque(Integer cdEstoque, Integer cdProduto, Integer quantidade) {
		super();
		this.cdEstoque = cdEstoque;
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
	}


	public Integer getCdEstoque() {
		return cdEstoque;
	}

	public void setCdEstoque(Integer cdEstoque) {
		this.cdEstoque = cdEstoque;
	}

	public Integer getcdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Integer idProduto) {
		this.cdProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [idEstoque=" + cdEstoque + ", idProduto=" + cdProduto + ", quantidade=" + quantidade + "]";
	}


}
