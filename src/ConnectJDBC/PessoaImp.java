package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

<<<<<<< HEAD:BoxControl/src/ConnectJDBC/PessoaImp.java
=======
import GetConnection.GetConnection;
>>>>>>> teste:src/ConnectJDBC/PessoaImp.java
import dao.PessoaDAO;
import entity.Pessoa;

public class PessoaImp implements PessoaDAO {
	private Connection conn = null; 
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

		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('pessoa_cdpessoa_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into pessoa(cdpessoa, cpf, nome, data_nasc) VALUES (?, ?, ?, ?)");
		stm.setInt(1, id);
		stm.setString(2, pessoa.getCpf());
		stm.setString(3, pessoa.getNome());
		stm.setDate(4, new java.sql.Date(dataAtt.getTime()));
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdpessoa) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

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
	public void update(Integer cdpessoa, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE pessoa SET nome = (?) where cdpessoa = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdpessoa);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdpessoa) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from pessoa where cdpessoa = (?)");
		stm.setInt(1, cdpessoa);
		stm.executeUpdate();
	}

	@Override
	public Collection<Pessoa> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from pessoa order by cdpessoa");
		rs = stm.executeQuery();

		Collection<Pessoa> peoples = new ArrayList<>();

		while(rs.next()) {
			int cdPessoa = rs.getInt("cdpessoa");
			String cpf = rs.getString("cpf");
			String nome = rs.getString("nome");
			String dataNasc = rs.getString("data_nasc");

			peoples.add(new Pessoa(cdPessoa, cpf, nome, dataNasc));
		}
		return peoples;
	}
	
}
