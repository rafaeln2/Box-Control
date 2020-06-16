package Relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GetConnection.GetConnection;
import RelatorioEntity.RelatorioProdutoEntity;

public class RelatorioDeProduto {
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<RelatorioProdutoEntity> callRelatorioProduto() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement(
				"SELECT p.descr,count(c.cdproduto) AS quantidade FROM carrinho c "
				+ "inner join produto p on p.cdproduto = c.cdproduto group by p.descr;"
				);
		rs = stm.executeQuery();

		ArrayList<RelatorioProdutoEntity> relatorioProdutoArray = new ArrayList<>();

		while(rs.next()) {
			String nome = rs.getString("descr");
			int quantidade = rs.getInt("quantidade");
			
			RelatorioProdutoEntity relatorioProduto = new RelatorioProdutoEntity(nome, quantidade);
			relatorioProdutoArray.add(relatorioProduto);
		}
		return relatorioProdutoArray;
	}
}
