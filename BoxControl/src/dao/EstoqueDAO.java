package dao;

import java.util.Collection;

import entity.Estoque;


public interface EstoqueDAO {

	public void create(Estoque estoque) throws Exception;

	public void read(Integer cdEstoque)throws Exception;

	public void update(Integer cdEstoque, String toUpdate)throws Exception;

	public void delete(Integer cdEstoque)throws Exception;

	Collection<Estoque> list()throws Exception;

}
