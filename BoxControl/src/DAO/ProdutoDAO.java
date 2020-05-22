package DAO;

import java.util.Collection;

import Entity.Produto;


public interface ProdutoDAO {

public void createEntity(Produto produto) throws Exception;
	
	public void updateEntity(Produto produto)throws Exception;
	
	public Produto findEntity(Produto produto)throws Exception;
	
	public void dropEntity(Produto produto)throws Exception;
	
	Collection<Produto> list()throws Exception;
}
