package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import DAO.PessoaDAO;
import Entity.Pessoa;

public class PessoaImp implements PessoaDAO {
	Connection conn = null; 
	PreparedStatement stm;
	ResultSet rs;
	Statement sttm;

	@Override
	public void create(Pessoa pessoa) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		conn.setAutoCommit(false);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String data = pessoa.getDataNasc(); 
		Date dataAtt = formatter.parse(data);

		stm = conn.prepareStatement("insert into pessoa( cpf, nome, data_nasc) VALUES (?, ?, ?)");

		Integer id = this.getId();
		pessoa.setIdPessoa(id);

		stm.setString(1, pessoa.getCpf());
		stm.setString(2, pessoa.getNome());
		stm.setDate(3, new java.sql.Date(dataAtt.getTime()));

		stm.execute();
		conn.commit();
	}

	@Override
	public void update(Integer idPessoa, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		conn.setAutoCommit(false);

		stm = conn.prepareStatement("UPDATE pessoa SET nome = (?) where cdpessoa = (?)");
		
		stm.setString(1, toUpdate);
		stm.setInt(2, idPessoa);

		stm.execute();
		conn.commit();
	}

	@Override
	public Pessoa find(String cpfPessoa) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select * from pessoa");
		
		rs = stm.executeQuery();
		rs.next();
		
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("cdpessoa") + ", ");
			System.out.println("CPF: " + rs.getString("cpf")+ ", ");
			System.out.println("NOME: " + rs.getString("nome")+", ");
			System.out.println("DATA NASC: " + rs.getDate("data_nasc")+", ");
		}
		
		return null;
	}

	@Override
	public void drop(Integer idPessoa) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		sttm = conn.createStatement();
		ResultSet rs = sttm.executeQuery("");
		rs.next();


	}

	@Override
	public Collection<Pessoa> list() throws Exception {

		return null;
	}

	@Override
	public Integer getId() throws Exception {
		Statement sttm = conn.createStatement();
		rs = sttm.executeQuery("select nextval('pessoa_cdpessoa_seq'::regclass)");
		rs.next();
		return rs.getInt(1);
	}
}
