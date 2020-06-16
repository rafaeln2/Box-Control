package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
//import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import Entity.Pessoa;
import EntityDAO.PessoaDAO;
import GetConnection.GetConnection;

public class PessoaImp implements PessoaDAO {
	
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Pessoa pessoa) throws Exception {
		
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String data = pessoa.getDataNascimento(); 
		Date dataAtt = formatter.parse(data);
		
		stm = conn.prepareStatement("insert into pessoa(cpf, nome, data_nasc) VALUES (?, ?, ?)");
		stm.setString(1, pessoa.getCpf());
		stm.setString(2, pessoa.getNome());
		stm.setDate(3, new java.sql.Date(dataAtt.getTime()));
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdpessoa) from pessoa;");
		rs.next();
		int cdPessoa = rs.getInt(1);
		pessoa.setCdPessoa(cdPessoa);
				
	}

	@Override
	public void read(int cdpessoa) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from pessoa as p left join funcionario as f ON p.cdpessoa = f.cdpessoa where p.cdpessoa = (?) order by p.cdpessoa");
		stm.setInt(1, cdpessoa);

		rs = stm.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();

		int columnsNumber = rsmd.getColumnCount();

		while(rs.next()) {
			for(int i = 1; i <= columnsNumber; i++) {
				System.out.printf("{%s: %s} %n", rsmd.getColumnName(i), rs.getString(i));
			}
		}
	}

	@Override
	public void update(int cdpessoa, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE pessoa SET nome = (?) where cdpessoa = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdpessoa);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdpessoa) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from pessoa where cdpessoa = (?)");
		stm.setInt(1, cdpessoa);
		stm.executeUpdate();
	}

	@Override
	public Collection<Pessoa> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from pessoa order by cdpessoa");
		rs = stm.executeQuery();

		Collection<Pessoa> peoples = new ArrayList<>();

		while(rs.next()) {
			String cpf = rs.getString("cpf");
			String nome = rs.getString("nome");
			String dataNasc = rs.getString("data_nasc");

			peoples.add(new Pessoa(cpf, nome, dataNasc));
		}
		return peoples;
	}
	
}
