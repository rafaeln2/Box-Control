package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dao.FuncionarioDAO;
import entity.Funcionario;

public class FuncionarioImp implements FuncionarioDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Funcionario funcionario) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('funcionario_cdfuncionario_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into funcionario(CDFUNCIONARIO, SALARIO, CDPESSOA CDCARGO, CDUS) VALUES (?, ?, ?, ?, ?)");
		stm.setInt(1, id);
		stm.setFloat(2, funcionario.getSalario());
		stm.setInt(3, funcionario.getCdPessoa());
		stm.setInt(4, funcionario.getcdUs());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdFuncionario) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from funcionario where CDFUNCIONARIO = (?) order by CDFUNCIONARIO");
		stm.setInt(1, cdFuncionario);

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
	public void update(Integer cdFuncionario, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE funcionario SET salario = (?) where CDFUNCIONARIO = (?)");
		stm.setDouble(1, Double.parseDouble(toUpdate));
		stm.setInt(2, cdFuncionario);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdFuncionario) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from funcionario where CDFUNCIONARIO = (?)");
		stm.setInt(1, cdFuncionario);
		stm.executeUpdate();
	}

	@Override
	public Collection<Funcionario> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from funcionario order by CDFUNCIONARIO");
		rs = stm.executeQuery();

		Collection<Funcionario> funcionarios = new ArrayList<>();

		while(rs.next()) {
			Integer cdFuncionario = rs.getInt("CDFUNCIONARIO");
			Float salario = rs.getFloat("SALARIO");
			Integer cdPessoa = rs.getInt("CDPESSOA");
			Integer cdCargo = rs.getInt("CDCARGO");
			Integer cdUs = rs.getInt("CDUS");
			
			funcionarios.add(new Funcionario(cdFuncionario, salario, cdPessoa, cdCargo, cdUs));
		}
		return funcionarios;
	}

}
