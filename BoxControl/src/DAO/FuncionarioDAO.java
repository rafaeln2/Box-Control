package DAO;

import java.util.Collection;

import Entity.Funcionario;

public interface FuncionarioDAO {
	
	public void create(Funcionario funcionario) throws Exception;
	
	public void read(Integer cdFuncionario)throws Exception;
	
	public void update(Integer cdFuncionario, String toUpdate)throws Exception;
	
	public void delete(Integer cdFuncionario)throws Exception;
	
	Collection<Funcionario> list()throws Exception;
}
