package DAO;

import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	public void createEntity(Pessoa pessoa) throws Exception;
	
	public void updateEntity( Pessoa pessoa)throws Exception;
	
	public Pessoa findEntity(Pessoa pessoa)throws Exception;
	
	public void dropEntity(Pessoa pessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
}
