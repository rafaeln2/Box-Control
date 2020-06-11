package dao;

import java.util.Collection;

import entity.Estoque;


public interface EstoqueDAO {

	public void create(Estoque estoque) throws Exception;

	public void read(int cdEstoque)throws Exception;

	public void update(int cdEstoque, String toUpdate)throws Exception;

	public void delete(int cdEstoque)throws Exception;

	Collection<Estoque> list()throws Exception;

}
