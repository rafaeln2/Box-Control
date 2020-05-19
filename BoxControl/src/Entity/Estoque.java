package Entity;

public class Estoque {

	private Integer idEstoque;
	private Integer idProduto;
	private Integer quantidade;

	public Estoque() {

	}

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [idEstoque=" + idEstoque + ", idProduto=" + idProduto + ", quantidade=" + quantidade + "]";
	}


}
