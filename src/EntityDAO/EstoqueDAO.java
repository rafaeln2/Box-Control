package EntityDAO;

import java.util.Collection;

import Entity.Estoque;


public interface EstoqueDAO {

	public void create(Estoque estoque) throws Exception;

	public void read(int cdEstoque)throws Exception;

	public void update(int cdEstoque, String toUpdate)throws Exception;

	public void delete(int cdEstoque)throws Exception;

	Collection<Estoque> list()throws Exception;

}
