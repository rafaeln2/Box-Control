package ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

import DAO.PessoaDAO;
import Entity.Pessoa;

public class PessoaImp implements PessoaDAO {
	Connection conn = null;
	PreparedStatement stm;
	@Override
	public void createEntity(Pessoa pessoa) throws Exception {
		conn.prepareStatement("insert into pessoa(idPessoa, cpf, nome, dataNasc VALUES (?, ?, ?, ?)");
		stm.setInt(1, pessoa.getIdPessoa());
		stm.setString(2, pessoa.getNome());
		stm.execute();
		conn.commit();
	}

	@Override
	public void updateEntity(Pessoa pessoa) throws Exception {
		conn.prepareStatement("update pessoa set nome = (?) where idPessoa = (?)");
	}

	@Override
	public Pessoa findEntity(Integer idPessoa) throws Exception {
		conn.prepareStatement("select * from pessoa where idPessoa = (?)");
		return null;
	}

	@Override
	public void dropEntity(Integer idPessoa) throws Exception {
		conn.prepareStatement("delete from pessoa where idPessoa = (?)");
	}

	@Override
	public Collection<Pessoa> list() throws Exception {

		return null;
	}
	
	
}
