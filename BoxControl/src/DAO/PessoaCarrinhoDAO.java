package DAO;

import java.util.Collection;

import Entity.PessoaCarrinho;


public interface PessoaCarrinhoDAO {
	
	public void createEntity(PessoaCarrinho pessoaCarrinho) throws Exception;

	public void updateEntity(PessoaCarrinho pessoaCarrinho)throws Exception;

	public PessoaCarrinho findEntity(PessoaCarrinho pessoaCarrinho)throws Exception;

	public void dropEntity(PessoaCarrinho pessoaCarrinho)throws Exception;

	Collection<PessoaCarrinho> list()throws Exception;
}
