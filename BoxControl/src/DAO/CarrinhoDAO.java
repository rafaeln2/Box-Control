package DAO;

import java.util.Collection;

import Entity.Carrinho;


public interface CarrinhoDAO {
	
	public void createEntity(Carrinho Carrinho) throws Exception;

	public void updateEntity(Carrinho Carrinho)throws Exception;

	public Carrinho findEntity(Carrinho Carrinho)throws Exception;

	public void dropEntity(Carrinho Carrinho)throws Exception;

	Collection<Carrinho> list()throws Exception;
}
