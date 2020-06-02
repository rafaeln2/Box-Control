package entity;

public class Venda {

	private Integer cdVenda;
	private String data;

	public Venda() {

	}
	public Venda(String data) {
		super();
		this.data = data;
	}
	public Venda(Integer cdVenda, String data) {
		super();
		this.cdVenda = cdVenda;
		this.data = data;
	}

	public Integer getcdVenda() {
		return cdVenda;
	}

	public void setcdVenda(Integer cdVenda) {
		this.cdVenda = cdVenda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Venda [cdVenda=" + cdVenda + ", data=" + data + "]";
	}


}
