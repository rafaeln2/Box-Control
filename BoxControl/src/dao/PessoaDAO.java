package dao;

import java.util.Collection;

import entity.Pessoa;

public interface PessoaDAO {

	
	public void create(Pessoa pessoa) throws Exception;
	
	public void read(Integer cdPessoa)throws Exception;
	
	public void update(Integer cdPessoa, String toUpdate)throws Exception;
	
	public void delete(Integer cdPessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
}
