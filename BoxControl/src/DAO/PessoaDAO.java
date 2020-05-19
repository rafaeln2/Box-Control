package DAO;

import java.sql.Connection;
import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	public void createEntity(Connection conn, Pessoa pessoa) throws Exception;
	
	public void updateEntity(Connection conn, Pessoa pessoa)throws Exception;
	
	public Pessoa findEntity(Connection conn, Pessoa pessoa)throws Exception;
	
	public void dropEntity(Connection conn, Pessoa pessoa)throws Exception;
	
	Collection<Pessoa> list(Connection conn)throws Exception;
	
}
