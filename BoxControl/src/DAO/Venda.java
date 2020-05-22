package DAO;

import java.util.Collection;


public interface Venda {
	
public void createEntity(Venda venda) throws Exception;
	
	public void updateEntity(Venda venda)throws Exception;
	
	public Venda findEntity(Venda venda)throws Exception;
	
	public void dropEntity(Venda venda)throws Exception;
	
	Collection<Venda> list()throws Exception;
}
