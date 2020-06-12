package Entity;

public class Carrinho {
	
	private int cdcarrinho;
	private int cdFuncionario;
	private int cdVenda;
	private int cdProduto;
	private int quantidade;
	
	public Carrinho(int cdFuncionario, int cdVenda, int cdProduto, int quantidade) {
		this.cdFuncionario = cdFuncionario;
		this.cdVenda = cdVenda;
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
	}
	
	public int getCdcarrinho() {
		return cdcarrinho;
	}
	
	public void setCdcarrinho(int cdcarrinho) {
		this.cdcarrinho = cdcarrinho;
	}
	
	public int getCdFuncionario() {
		return cdFuncionario;
	}
	
	public void setCdFuncionario(int cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}
	
	public int getCdVenda() {
		return cdVenda;
	}
	
	public void setCdVenda(int cdVenda) {
		this.cdVenda = cdVenda;
	}
	
	public int getCdProduto() {
		return cdProduto;
	}
	
	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "Carrinho [cdcarrinho=" + cdcarrinho + ", cdFuncionario=" + cdFuncionario + ", cdVenda=" + cdVenda
				+ ", cdProduto=" + cdProduto + ", quantidade=" + quantidade + "]";
	}
	
}
