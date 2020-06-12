package EntityDAO;

import java.util.Collection;

import Entity.UsuarioSenha;


public interface UsuarioSenhaDAO {

	public void create(UsuarioSenha usuarioSenha) throws Exception;

	public void read(int cdUsuarioSenha)throws Exception;

	public void update(int cdUsuarioSenha, String toUpdate)throws Exception;

	public void delete(int cdUsuarioSenha)throws Exception;

	Collection<UsuarioSenha> list()throws Exception;
}
