package EntityDAO;

import java.util.Collection;

import Entity.Telefone;


public interface TelefoneDAO {

	public void create(Telefone telefone) throws Exception;

	public void read(int cdTelefone)throws Exception;

	public void update(int cdTelefone, String toUpdate)throws Exception;

	public void delete(int cdTelefone)throws Exception;

	Collection<Telefone> list()throws Exception;
}
