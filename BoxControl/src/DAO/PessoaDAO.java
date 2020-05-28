package DAO;

import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	
	public void create(Pessoa pessoa) throws Exception;
	
	public void update(Integer idPessoa, String toUpdate)throws Exception;
	
	public Pessoa find(String cpfPessoa)throws Exception;
	
	public void drop(Integer idPessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
	public Integer getId()throws Exception; 
}
