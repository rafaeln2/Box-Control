package EntityDAO;

import java.util.Collection;

import Entity.Produto;


public interface ProdutoDAO {

	public void create(Produto produto) throws Exception;

	public void read(int cdProduto)throws Exception;

	public void update(int cdProduto, String toUpdate)throws Exception;

	public void delete(int cdProduto)throws Exception;

	Collection<Produto> list()throws Exception;
}
