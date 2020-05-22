package DAO;

import java.util.Collection;

import Entity.Endereco;

public interface EnderecoDAO {

	public void createEntity(Endereco endereco) throws Exception;
	
	public void updateEntity(Endereco endereco)throws Exception;
	
	public Endereco findEntity(Endereco endereco)throws Exception;
	
	public void dropEntity(Endereco endereco)throws Exception;
	
	Collection<Endereco> list()throws Exception;
}
