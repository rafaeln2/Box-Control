package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import GetConnection.GetConnection;
import dao.TelefoneDAO;
import entity.Telefone;

public class TelefoneImp implements TelefoneDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Telefone telefone) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('telefone_cdtelefone_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into telefone(cdtelefone, tipo_telefone, ddd, numero, cdpessoa) VALUES (?, ?, ?, ?, ?)");
		stm.setInt(1, id);
		stm.setString(2, telefone.getTipoTelefone());
		stm.setString(3, telefone.getDdd());
		stm.setString(4, telefone.getNumero());
		stm.setInt(5, telefone.getCdPessoa());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdTelefone) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from telefone where cdtelefone = (?) order by cdtelefone");
		stm.setInt(1, cdTelefone);

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
	public void update(Integer cdTelefone, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE telefone SET numero = (?) where cdtelefone = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdTelefone);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdTelefone) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from telefone where cdtelefone = (?)");
		stm.setInt(1, cdTelefone);
		stm.executeUpdate();
	}

	@Override
	public Collection<Telefone> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from telefone order by cdtelefone");
		rs = stm.executeQuery();

		Collection<Telefone> telefones = new ArrayList<>();

		while(rs.next()) {
			Integer cdtelefone = rs.getInt("CDTELEFONE");
			String tipoTelefone = rs.getString("TIPO_TELEFONE");
			String ddd = rs.getString("DDD");
			String numero = rs.getString("NUMERO");
			Integer cdPessoa = rs.getInt("CDPESSOA");

			telefones.add(new Telefone(cdtelefone, tipoTelefone, ddd, numero, cdPessoa));
		}
		return telefones;
	}

}
