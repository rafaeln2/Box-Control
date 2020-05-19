package Entity;

public class PessoaCarrinho {
	
	private Integer idPessoa;
	private Integer idFuncionario;
	private Integer idVenda;
	private Integer idProduto;
	private Integer quantidade;
	private Double valorVendido;
	private Integer nu_caixa;
	private String tipoPagamento;
	
	public PessoaCarrinho() {
		
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
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

	public Double getValorVendido() {
		return valorVendido;
	}

	public void setValorVendido(Double valorVendido) {
		this.valorVendido = valorVendido;
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
		return "PessoaCarrinho [idPessoa=" + idPessoa + ", idFuncionario=" + idFuncionario + ", idVenda=" + idVenda
				+ ", idProduto=" + idProduto + ", quantidade=" + quantidade + ", valorVendido=" + valorVendido
				+ ", nu_caixa=" + nu_caixa + ", tipoPagamento=" + tipoPagamento + "]";
	}
	
	
}
