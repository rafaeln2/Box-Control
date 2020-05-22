package DAO;

import java.util.Collection;

import Entity.Estoque;


public interface EstoqueDAO {

public void createEntity(Estoque estoque) throws Exception;
	
	public void updateEntity(Estoque estoque)throws Exception;
	
	public Estoque findEntity(Estoque estoque)throws Exception;
	
	public void dropEntity(Estoque estoque)throws Exception;
	
	Collection<Estoque> list()throws Exception;
	
}
