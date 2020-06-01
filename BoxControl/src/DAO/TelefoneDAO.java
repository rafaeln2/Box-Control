package DAO;

import java.util.Collection;

import Entity.Telefone;


public interface TelefoneDAO {

	public void create(Telefone telefone) throws Exception;

	public void create(Integer cdTelefone)throws Exception;

	public void update(Integer cdTelefone, String toUpdate)throws Exception;

	public void delete(Integer cdTelefone)throws Exception;

	Collection<Telefone> list()throws Exception;
}
