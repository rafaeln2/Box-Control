package dao;

import java.util.Collection;

import entity.Carrinho;


public interface CarrinhoDAO {
	
	public void create(Carrinho carrinho) throws Exception;

	public void read(int cdCarrinho)throws Exception;

	public void update(int cdCarrinho, String toUpdate)throws Exception;

	public void delete(int cdCarrinho)throws Exception;

	Collection<Carrinho> list()throws Exception;
}
