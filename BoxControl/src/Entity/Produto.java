package entity;

public class Produto {

	private Integer cdProduto;
	private String desc;
	private Float valor;
	private String marca;
	private String um; //enum
	
	public Produto() {
		
	}

	public Produto(String desc, Float valor, String marca, String um) {
		this.desc = desc;
		this.valor = valor;
		this.marca = marca;
		this.um = um;
	}

	public Produto(Integer cdProduto, String desc, Float valor, String marca, String um) {
		this.cdProduto = cdProduto;
		this.desc = desc;
		this.valor = valor;
		this.marca = marca;
		this.um = um;
	}

	public Integer getcdProduto() {
		return cdProduto;
	}

	public void setcdProduto(Integer cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
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
		return "Produto [cdProduto=" + cdProduto + ", desc=" + desc + ", valor=" + valor + ", marca=" + marca + ", um="
				+ um + "]";
	}
	
	
}
