package Entity;

import java.util.Date;

public class Venda {

	private int cdVenda;
	private Date data;

	public Venda(Date data) {
		super();
		this.data = data;
	}

	public int getcdVenda() {
		return cdVenda;
	}

	public void setcdVenda(int cdVenda) {
		this.cdVenda = cdVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Venda [cdVenda=" + cdVenda + ", data=" + data + "]";
	}


}
