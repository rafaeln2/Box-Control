package DAO;

import java.util.Collection;

import Entity.Funcionario;

public interface FuncionarioDAO {
	
	public void createEntity(Funcionario funcionario) throws Exception;
	
	public void updateEntity(Funcionario funcionario)throws Exception;
	
	public Funcionario findEntity(Funcionario funcionario)throws Exception;
	
	public void dropEntity(Funcionario funcionario)throws Exception;
	
	Collection<Funcionario> list()throws Exception;
}
