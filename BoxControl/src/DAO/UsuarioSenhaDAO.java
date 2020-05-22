package DAO;

import java.util.Collection;

import Entity.UsuarioSenha;


public interface UsuarioSenhaDAO {

public void createEntity(UsuarioSenha usuarioSenha) throws Exception;
	
	public void updateEntity(UsuarioSenha usuarioSenha)throws Exception;
	
	public UsuarioSenha findEntity(UsuarioSenha usuarioSenha)throws Exception;
	
	public void dropEntity(UsuarioSenha usuarioSenha)throws Exception;
	
	Collection<UsuarioSenhaDAO> list()throws Exception;
}
