package Relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GetConnection.GetConnection;
import RelatorioEntity.RelatorioFuncionarioVendaEntity;

public class RelatorioDeFuncionarioVenda {
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<RelatorioFuncionarioVendaEntity> callRelatorioFuncionario() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement(
				"SELECT p.nome,count(p.nome) AS quantidade FROM carrinho c "
				+ "inner join funcionario f on f.cdfuncionario = c.cdfuncionario "
				+ "inner join pessoa p on p.cdpessoa = f.cdpessoa group by p.nome;"
				);
		rs = stm.executeQuery();

		ArrayList<RelatorioFuncionarioVendaEntity> relatorioFuncionarioArray = new ArrayList<>();

		while(rs.next()) {
			String nome = rs.getString("nome");
			int quantidade = rs.getInt("quantidade");
			
			RelatorioFuncionarioVendaEntity relatorioVenda = new RelatorioFuncionarioVendaEntity(nome, quantidade);
			relatorioFuncionarioArray.add(relatorioVenda);
		}
		return relatorioFuncionarioArray;
	}
}
