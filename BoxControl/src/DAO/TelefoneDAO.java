package DAO;

import java.util.Collection;

import Entity.Telefone;


public interface TelefoneDAO {
	
public void createEntity(Telefone telefone) throws Exception;
	
	public void updateEntity(Telefone telefone)throws Exception;
	
	public Telefone findEntity(Telefone telefone)throws Exception;
	
	public void dropEntity(Telefone telefone)throws Exception;
	
	Collection<Telefone> list()throws Exception;
}
