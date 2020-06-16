package EntityDAO;

import java.util.Collection;

import Entity.Endereco;

public interface EnderecoDAO {

	public void create(Endereco endereco) throws Exception;
	
	public void read(int cdEndereco)throws Exception;
	
	public void update(int cdEndereco, String toUpdate)throws Exception;
	
	public void delete(int cdEndereco)throws Exception;
	
	Collection<Endereco> list()throws Exception;
}
