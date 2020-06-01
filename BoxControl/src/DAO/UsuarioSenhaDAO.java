package DAO;

import java.util.Collection;

import Entity.UsuarioSenha;


public interface UsuarioSenhaDAO {

	public void create(UsuarioSenha usuarioSenha) throws Exception;

	public void read(Integer cdUsuarioSenha)throws Exception;

	public void update(Integer cdUsuarioSenha, String toUpdate)throws Exception;

	public void delete(Integer cdUsuarioSenha)throws Exception;

	Collection<UsuarioSenha> list()throws Exception;
}
