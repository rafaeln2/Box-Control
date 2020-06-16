package Relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GetConnection.GetConnection;
import RelatorioEntity.RelatorioEstoqueEntity;

public class RelatorioDeEstoque {
	private PreparedStatement stm;
	private ResultSet rs;

	public ArrayList<RelatorioEstoqueEntity> callRelatorioEstoque() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("SELECT PR.CDPRODUTO,PR.DESCR,E.QUANTIDADE FROM PRODUTO PR INNER JOIN ESTOQUE E ON E.CDPRODUTO = PR.CDPRODUTO;");
		rs = stm.executeQuery();

		ArrayList<RelatorioEstoqueEntity> estoques = new ArrayList<>();

		while(rs.next()) {
			int cdProduto = rs.getInt("CDPRODUTO");
			String nomeProduto = rs.getString("DESCR");
			int quantidadeProduto = rs.getInt("QUANTIDADE");
			
			RelatorioEstoqueEntity estoque = new RelatorioEstoqueEntity(cdProduto, nomeProduto, quantidadeProduto);
			estoques.add(estoque);
			System.out.println("Estoque"+estoque);
		}
		return estoques;
	}
}
