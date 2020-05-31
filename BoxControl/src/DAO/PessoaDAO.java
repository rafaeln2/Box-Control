package DAO;

import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	
	public void create(Pessoa pessoa) throws Exception;
	
	public Pessoa read(Integer idPessoa)throws Exception;
	
	public void update(Integer idPessoa, String toUpdate)throws Exception;
	
	public void delete(Integer idPessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
}
