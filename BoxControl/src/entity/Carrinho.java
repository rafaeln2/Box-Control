package entity;

public class Carrinho {
	
	private Integer cdcarrinho;
	private Integer cdFuncionario;
	private Integer cdVenda;
	private Integer cdProduto;
	private Integer quantidade;
	private Integer nu_caixa;
	private String tipoPagamento; //enum
	
	public Carrinho() {
	}
	
	public Carrinho(Integer cdcarrinho, Integer cdFuncionario, Integer cdVenda, Integer cdProduto, Integer quantidade,
			Integer nu_caixa, String tipoPagamento) {
		super();
		this.cdcarrinho = cdcarrinho;
		this.cdFuncionario = cdFuncionario;
		this.cdVenda = cdVenda;
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
		this.nu_caixa = nu_caixa;
		this.tipoPagamento = tipoPagamento;
	}

	public Carrinho(Integer cdFuncionario, Integer cdVenda, Integer cdProduto, Integer quantidade, Integer nu_caixa, String tipoPagamento) {
		this.cdFuncionario = cdFuncionario;
		this.cdVenda = cdVenda;
		this.cdProduto = cdProduto;
		this.quantidade = quantidade;
		this.nu_caixa = nu_caixa;
		this.tipoPagamento = tipoPagamento;
	}
	public Integer getCdcarrinho() {
		return cdcarrinho;
	}
	public void setCdcarrinho(Integer cdcarrinho) {
		this.cdcarrinho = cdcarrinho;
	}
	public Integer getCdFuncionario() {
		return cdFuncionario;
	}
	public void setCdFuncionario(Integer cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}
	public Integer getCdVenda() {
		return cdVenda;
	}
	public void setCdVenda(Integer cdVenda) {
		this.cdVenda = cdVenda;
	}
	public Integer getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(Integer cdProduto) {
		this.cdProduto = cdProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getNu_caixa() {
		return nu_caixa;
	}
	public void setNu_caixa(Integer nu_caixa) {
		this.nu_caixa = nu_caixa;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	@Override
	public String toString() {
		return "Carrinho [cdcarrinho=" + cdcarrinho + ", cdFuncionario=" + cdFuncionario + ", cdVenda=" + cdVenda
				+ ", cdProduto=" + cdProduto + ", quantidade=" + quantidade + ", nu_caixa=" + nu_caixa + ", tipoPagamento=" + tipoPagamento + "]";
	}
	
}
