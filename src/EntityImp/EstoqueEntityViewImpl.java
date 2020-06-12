package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Estoque;
import Entity.EstoqueEntityView;
import GetConnection.GetConnection;

public class EstoqueEntityViewImpl {
	private PreparedStatement stm;
	private ResultSet rs;

	public ArrayList<EstoqueEntityView> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("SELECT PR.CDPRODUTO,PR.DESCR,E.QUANTIDADE FROM PRODUTO PR INNER JOIN ESTOQUE E ON E.CDPRODUTO = PR.CDPRODUTO;");
		rs = stm.executeQuery();

		ArrayList<EstoqueEntityView> estoques = new ArrayList<>();

		while(rs.next()) {
			int cdProduto = rs.getInt("CDPRODUTO");
			String nomeProduto = rs.getString("DESCR");
			int quantidadeProduto = rs.getInt("QUANTIDADE");
			
			EstoqueEntityView estoque = new EstoqueEntityView(cdProduto, nomeProduto, quantidadeProduto);
			estoques.add(estoque);
			System.out.println("Estoque"+estoque);
		}
		return estoques;
	}
	
}
