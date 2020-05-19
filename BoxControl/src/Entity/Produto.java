package Entity;

public class Produto {

	private Integer idProduto;
	private String desc;
	private Double valor;
	private String marca;
	private String um;
	
	public Produto() {
		
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", desc=" + desc + ", valor=" + valor + ", marca=" + marca + ", um="
				+ um + "]";
	}
	
	
}
