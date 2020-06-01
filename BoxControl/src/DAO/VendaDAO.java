package DAO;

import java.util.Collection;

import Entity.Venda;


public interface VendaDAO {

	public void create(Venda venda) throws Exception;

	public void read(Integer cdVenda)throws Exception;

	public void update(Integer cdVenda, String toUpdate)throws Exception;

	public void delete(Integer cdVenda)throws Exception;

	Collection<Venda> list()throws Exception;
}
