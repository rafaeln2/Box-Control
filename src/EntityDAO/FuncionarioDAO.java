package EntityDAO;

import java.util.Collection;

import Entity.Funcionario;

public interface FuncionarioDAO {
	
	public void create(Funcionario funcionario) throws Exception;
	
	public void read(int cdFuncionario)throws Exception;
	
	public void update(int cdFuncionario, String toUpdate)throws Exception;
	
	public void delete(int cdFuncionario)throws Exception;
	
	Collection<Funcionario> list()throws Exception;
}
