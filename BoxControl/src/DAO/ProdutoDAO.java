package DAO;

import java.util.Collection;

import Entity.Produto;


public interface ProdutoDAO {

	public void create(Produto produto) throws Exception;

	public void read(Integer cdProduto)throws Exception;

	public void update(Integer cdProduto, String toUpdate)throws Exception;

	public void delete(Integer cdProduto)throws Exception;

	Collection<Produto> list()throws Exception;
}
