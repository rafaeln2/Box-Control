package Relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import GetConnection.GetConnection;
import RelatorioEntity.RelatorioVendaEntity;

public class RelatorioDeVendas {
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<RelatorioVendaEntity> callRelatorioVendas() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement(
				"select p.nome,v.data,pr.descr,c.quantidade from carrinho c "
				+ "inner join produto pr on pr.cdproduto = c.cdproduto inner join venda v on v.cdvenda=c.cdvenda "
				+ "inner join funcionario f on f.cdfuncionario = c.cdfuncionario "
				+ "inner join pessoa p on p.cdpessoa = f.cdpessoa;"
				);
		rs = stm.executeQuery();

		ArrayList<RelatorioVendaEntity> relatorioVendaArray = new ArrayList<>();

		while(rs.next()) {
			String nome = rs.getString("nome");
			Date data = rs.getDate("data");
			String descricao = rs.getString("descr");
			int quantidade = rs.getInt("quantidade");
			
			RelatorioVendaEntity relatorioVenda = new RelatorioVendaEntity(nome, data.toString(), descricao, quantidade);
			relatorioVendaArray.add(relatorioVenda);
		}
		return relatorioVendaArray;
	}
}
