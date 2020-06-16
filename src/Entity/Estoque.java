package Entity;

public class Estoque {

	private int cdEstoque;
	private int cdProduto;
	private int quantidade;

	public Estoque(int cdProduto, int quantidade) {
		
		super();
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
	}

	public int getCdEstoque() {
		return cdEstoque;
	}

	public void setCdEstoque(int cdEstoque) {
		this.cdEstoque = cdEstoque;
	}

	public int getcdProduto() {
		return cdProduto;
	}

	public void setCdProduto(int idProduto) {
		this.cdProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [idEstoque=" + cdEstoque + ", idProduto=" + cdProduto + ", quantidade=" + quantidade + "]";
	}


}
