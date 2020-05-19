package Entity;

import java.sql.Date;

public class Venda {

	private Integer idVenda;
	private Date data;

	public Venda() {

	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", data=" + data + "]";
	}


}
