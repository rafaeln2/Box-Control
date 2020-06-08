package ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import GetConnection.GetConnection;
import dao.FuncionarioDAO;
import entity.Funcionario;

public class FuncionarioImp implements FuncionarioDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	//private Statement sttm;

	@Override
	public void create(Funcionario funcionario) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();

		stm = conn.prepareStatement("insert into funcionario(SALARIO, CDPESSOA, CDCARGO, CDUS) VALUES (?, ?, ?, ?)");
		stm.setFloat(1, funcionario.getSalario());
		stm.setInt(2, funcionario.getCdPessoa());
		stm.setInt(3, 1);
		stm.setInt(4, funcionario.getcdUs());
		stm.executeUpdate();
		System.out.println("Funcionario criado com sucesso !\n");
	}

	@Override
	public void read(int cdFuncionario) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
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
	public void update(int cdFuncionario, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE funcionario SET salario = (?) where CDFUNCIONARIO = (?)");
		stm.setDouble(1, Double.parseDouble(toUpdate));
		stm.setInt(2, cdFuncionario);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdFuncionario) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from funcionario where CDFUNCIONARIO = (?)");
		stm.setInt(1, cdFuncionario);
		stm.executeUpdate();
	}

	@Override
	public Collection<Funcionario> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from funcionario order by CDFUNCIONARIO");
		rs = stm.executeQuery();
		PreparedStatement selectFuncionarioData;
		ResultSet responseSelectFuncionarioData;
		Collection<Funcionario> funcionarios = new ArrayList<>();

		while(rs.next()) {
			int cdFuncionario = rs.getInt("CDFUNCIONARIO");
			float salario = rs.getFloat("SALARIO");
			int cdPessoa = rs.getInt("CDPESSOA");
			int cdCargo = rs.getInt("CDCARGO");
			int cdUs = rs.getInt("CDUS");
			
			selectFuncionarioData = conn.prepareStatement("SELECT P.NOME,P.CPF,P.DATA_NASC FROM PESSOA P\r\n" + 
					"INNER JOIN FUNCIONARIO F ON F.CDPESSOA = P.CDPESSOA\r\n" + 
					"WHERE CDFUNCIONARIO = "+ cdFuncionario +";");
			responseSelectFuncionarioData = selectFuncionarioData.executeQuery();
			while(responseSelectFuncionarioData.next()) {
				
				String nomeFuncionario = responseSelectFuncionarioData.getString("NOME");
				String cpfFuncionario = responseSelectFuncionarioData.getString("CPF");
				String dataNascFuncionario = responseSelectFuncionarioData.getString("DATA_NASC");
			
				funcionarios.add(new Funcionario(salario, cdPessoa, cdCargo, cdUs, cpfFuncionario, nomeFuncionario, dataNascFuncionario));
			}
			System.out.println("Funcionarios no Banco: "+ funcionarios.toString());
		}
		return funcionarios;
	}

}
