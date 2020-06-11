package dao;

import java.util.Collection;

import entity.Venda;


public interface VendaDAO {

	public void create(Venda venda) throws Exception;

	public void read(int cdVenda)throws Exception;

	public void update(int cdVenda, String toUpdate)throws Exception;

	public void delete(int cdVenda)throws Exception;

	Collection<Venda> list()throws Exception;
}
