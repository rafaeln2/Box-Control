package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Endereco;
import EntityDAO.EnderecoDAO;
import GetConnection.GetConnection;

public class EnderecoImp implements EnderecoDAO{
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Endereco endereco) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement("insert into endereco(rua, num_endereco, bairro, cidade, estado, cep, cdpessoa) VALUES (?, ?, ?, ?, ?, ?, ?)");
		stm.setString(1, endereco.getRua());
		stm.setString(2, endereco.getNuEndereco());
		stm.setString(3, endereco.getBairro());
		stm.setString(4, endereco.getCidade());
		stm.setString(5, endereco.getEstado());
		stm.setString(6, endereco.getCep());
		stm.setInt(7, endereco.getCdPessoa());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdendereco) from endereco;");
		rs.next();
		int cdEndereco = rs.getInt(1);
		endereco.setCdEndereco(cdEndereco);
	}

	@Override
	public void read(int cdEndereco) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from endereco where cdendereco = (?) order by cdendereco");
		stm.setInt(1, cdEndereco);

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
	public void update(int cdEndereco, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE endereco SET rua = (?) where cdendereco = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdEndereco);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdEndereco) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from endereco where cdendereco = (?)");
		stm.setInt(1, cdEndereco);
		stm.executeUpdate();
	}

	@Override
	public Collection<Endereco> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from endereco order by cdendereco");
		rs = stm.executeQuery();

		Collection<Endereco> enderecos = new ArrayList<>();

		while(rs.next()) {
			String rua = rs.getString("RUA");
			String nuEndereco = rs.getString("NUM_ENDERECO");
			String bairro = rs.getString("BAIRRO");
			String cidade = rs.getString("CIDADE");
			String estado = rs.getString("ESTADO");
			String cep = rs.getString("CEP");
			int cdpessoa = rs.getInt("CDPESSOA");

			enderecos.add(new Endereco(rua, nuEndereco, bairro, cidade, estado, cep, cdpessoa));
		}
		return enderecos;
	}

}
