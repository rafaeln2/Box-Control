package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.EnderecoDAO;
import Entity.Endereco;

public class EnderecoImp implements EnderecoDAO{
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Endereco endereco) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('funcionario_cdfuncionario_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into endereco(cdendereco, rua, num_endereco, bairro, cidade, estado, cep, cdpessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		stm.setInt(1, id);
		stm.setString(2, endereco.getRua());
		stm.setString(3, endereco.getNuEndereco());
		stm.setString(4, endereco.getBairro());
		stm.setString(5, endereco.getCidade());
		stm.setString(6, endereco.getEstado());
		stm.setString(7, endereco.getCep());
		stm.setInt(8, endereco.getCdPessoa());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdEndereco) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

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
	public void update(Integer cdEndereco, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE endereco SET rua = (?) where cdendereco = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdEndereco);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdEndereco) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from endereco where cdendereco = (?)");
		stm.setInt(1, cdEndereco);
		stm.executeUpdate();
	}

	@Override
	public Collection<Endereco> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from endereco order by cdendereco");
		rs = stm.executeQuery();

		Collection<Endereco> enderecos = new ArrayList<>();

		while(rs.next()) {
			Integer cdEndereco = rs.getInt("CDENDERECO");
			String rua = rs.getString("RUA");
			String nuEndereco = rs.getString("NUM_ENDERECO");
			String bairro = rs.getString("BAIRRO");
			String cidade = rs.getString("CIDADE");
			String estado = rs.getString("ESTADO");
			String cep = rs.getString("CEP");
			Integer cdpessoa = rs.getInt("CDPESSOA");

			enderecos.add(new Endereco(cdEndereco, rua, nuEndereco, bairro, cidade, estado, cep, cdpessoa));
		}
		return enderecos;
	}

}
