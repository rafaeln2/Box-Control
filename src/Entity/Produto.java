package Entity;

public class Produto {

	private int cdProduto;
	private String desc;
	private float valor;
	private String marca;
	
	public Produto(String desc, float valor, String marca) {
		this.desc = desc;
		this.valor = valor;
		this.marca = marca;
	}

	public int getcdProduto() {
		return cdProduto;
	}

	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Produto [cdProduto=" + cdProduto + ", desc=" + desc + ", valor=" + valor + ", marca=" + marca + "]";
	}
	
	
}
