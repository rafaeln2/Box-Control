package DAO;

import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	public void createEntity(Pessoa pessoa) throws Exception;
	
	public void updateEntity(Pessoa pessoa)throws Exception;
	
	public Pessoa findEntity(Integer idPessoa)throws Exception;
	
	public void dropEntity(Integer idPessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
}
