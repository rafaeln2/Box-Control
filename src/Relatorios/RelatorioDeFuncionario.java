package Relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import GetConnection.GetConnection;
import RelatorioEntity.RelatorioFuncionarioEntity;

public class RelatorioDeFuncionario {
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<RelatorioFuncionarioEntity> callRelatorioFuncionario() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement(
				"select p.cdpessoa,p.cpf,p.nome,p.data_nasc,f.cdfuncionario,f.salario,c.nm_cargo, c.cdcargo from pessoa p\r\n" + 
				"left outer join funcionario f on f.CDPESSOA = p.CDPESSOA\r\n" + 
				"left outer join cargo c on c.cdcargo = f.cdcargo\r\n" + 
				"where f.cdfuncionario is not null and f.isactive = true;"
				);
		rs = stm.executeQuery();

		ArrayList<RelatorioFuncionarioEntity> relatorioFuncionarioArray = new ArrayList<>();

		while(rs.next()) {
			
			String nome = rs.getString("nome");
			int cdPessoa = rs.getInt("cdpessoa");
			int cdCargo = rs.getInt("cdcargo");
			float salario = rs.getFloat("salario");
			Date dataNascimento = rs.getDate("data_nasc") ;
			String cpf = rs.getString("cpf");
			String nomeCargo = rs.getString("nm_cargo");
			
			RelatorioFuncionarioEntity relatorioFuncionario = new RelatorioFuncionarioEntity(salario, cdPessoa, cdCargo, cpf, nome, dataNascimento.toString());
			
			relatorioFuncionario.setNomeCargo(nomeCargo);
			relatorioFuncionarioArray.add(relatorioFuncionario);
		}
		return relatorioFuncionarioArray;
	}
}