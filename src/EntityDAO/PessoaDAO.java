package EntityDAO;

import java.util.Collection;

import Entity.Pessoa;

public interface PessoaDAO {

	
	public void create(Pessoa pessoa) throws Exception;
	
	public void read(int cdPessoa)throws Exception;
	
	public void update(int cdPessoa, String toUpdate)throws Exception;
	
	public void delete(int cdPessoa)throws Exception;
	
	Collection<Pessoa> list()throws Exception;
	
}
