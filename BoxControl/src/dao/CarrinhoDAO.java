package dao;

import java.util.Collection;

import entity.Carrinho;


public interface CarrinhoDAO {
	
	public void create(Carrinho carrinho) throws Exception;

	public void read(Integer cdCarrinho)throws Exception;

	public void update(Integer cdCarrinho, String toUpdate)throws Exception;

	public void delete(Integer cdCarrinho)throws Exception;

	Collection<Carrinho> list()throws Exception;
}
