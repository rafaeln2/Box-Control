package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Telefone;
import EntityDAO.TelefoneDAO;
import GetConnection.GetConnection;

public class TelefoneImp implements TelefoneDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Telefone telefone) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement("insert into telefone(tipo_telefone, ddd, numero, cdpessoa) VALUES (?, ?, ?, ?)");
		stm.setString(1, telefone.getTipoTelefone());
		stm.setString(2, telefone.getDdd());
		stm.setString(3, telefone.getNumero());
		stm.setInt(4, telefone.getCdPessoa());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdtelefone) from telefone;");
		rs.next();
		int cdTelefone = rs.getInt(1);
		telefone.setCdTelefone(cdTelefone);	
	}

	@Override
	public void read(int cdTelefone) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
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
	public void update(int cdTelefone, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE telefone SET numero = (?) where cdtelefone = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdTelefone);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdTelefone) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from telefone where cdtelefone = (?)");
		stm.setInt(1, cdTelefone);
		stm.executeUpdate();
	}

	@Override
	public Collection<Telefone> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from telefone order by cdtelefone");
		rs = stm.executeQuery();

		Collection<Telefone> telefones = new ArrayList<>();

		while(rs.next()) {
			String tipoTelefone = rs.getString("TIPO_TELEFONE");
			String ddd = rs.getString("DDD");
			String numero = rs.getString("NUMERO");
			int cdPessoa = rs.getInt("CDPESSOA");
			telefones.add(new Telefone(tipoTelefone, ddd, numero, cdPessoa));
		}
		return telefones;
	}

}
