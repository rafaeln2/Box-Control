package DAO;

import java.sql.Connection;
import java.util.Collection;

public interface PessoaDAO {

	public void createEntity(Connection conn, Object entity) throws Exception;
	
	public void alterEntity(Connection conn, Object pessoa)throws Exception;;
	
	public Object findEntity(Connection conn, Object pessoa)throws Exception;;
	
	public void deleteEntity(Connection conn, Object pessoa)throws Exception;;
	
	Collection<Object> list(Connection conn)throws Exception;;
	
}
