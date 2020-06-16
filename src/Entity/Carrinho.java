package Entity;

public class Carrinho {
	
	private int cdcarrinho;
	private int cdFuncionario;
	private int cdVenda;
	private int cdProduto;
	private String tipoPagamento;
	private int quantidade;
	
	public Carrinho(int cdFuncionario, int cdVenda, int cdProduto, int quantidade, String tipoPagamento) {
		this.cdFuncionario = cdFuncionario;
		this.cdVenda = cdVenda;
		this.cdProduto = cdProduto;
		this.tipoPagamento = tipoPagamento;
		this.quantidade = quantidade;
	}
	
	public int getCdcarrinho() {
		return cdcarrinho;
	}
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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
				+ ", cdProduto=" + cdProduto + ", quantidade=" + quantidade + ", tipoPagamento=" + tipoPagamento+"]";
	}
	
}
