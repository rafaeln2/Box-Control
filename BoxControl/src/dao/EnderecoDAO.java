package dao;

import java.util.Collection;

import entity.Endereco;

public interface EnderecoDAO {

	public void create(Endereco endereco) throws Exception;
	
	public void read(Integer cdEndereco)throws Exception;
	
	public void update(Integer cdEndereco, String toUpdate)throws Exception;
	
	public void delete(Integer cdEndereco)throws Exception;
	
	Collection<Endereco> list()throws Exception;
}
