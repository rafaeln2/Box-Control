package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Estoque;
import EntityDAO.EstoqueDAO;
import GetConnection.GetConnection;

public class EstoqueImp implements EstoqueDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Estoque estoque) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();

		stm = conn.prepareStatement("insert into estoque(cdproduto, quantidade) VALUES (?, ?)");
		stm.setInt(1, estoque.getcdProduto());
		stm.setInt(2, estoque.getQuantidade());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdestoque) from estoque;");
		rs.next();
		int cdEstoque = rs.getInt(1);
		estoque.setCdEstoque(cdEstoque);
		
	}

	@Override
	public void read(int cdEstoque) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from estoque where cdestoque = (?) order by cdestoque");
		stm.setInt(1, cdEstoque);

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
	public void update(int cdEstoque, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE estoque SET cdproduto = (?) where cdestoque = (?)");
		stm.setInt(1, Integer.parseInt(toUpdate));
		stm.setInt(2, cdEstoque);
		stm.executeUpdate();
	}
	
	public void updateEstoque(int cdEstoque, int toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE estoque SET quantidade = (?) where cdestoque = (?)");
		stm.setInt(1, toUpdate);
		stm.setInt(2, cdEstoque);
		stm.executeUpdate();
		System.out.println("Atualizando" + cdEstoque);
	}

	@Override
	public void delete(int cdEstoque) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from estoque where estoque = (?)");
		stm.setInt(1, cdEstoque);
		stm.executeUpdate();
		
	}

	@Override
	public Collection<Estoque> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from estoque order by cdestoque");
		rs = stm.executeQuery();

		Collection<Estoque> estoques = new ArrayList<>();

		while(rs.next()) {
			int cdEstoque = rs.getInt("CDESTOQUE");
			int cdProduto = rs.getInt("CDPRODUTO");
			int quantidade = rs.getInt("QUANTIDADE");
			
			Estoque estoque = new Estoque(cdProduto, quantidade);
			estoque.setCdEstoque(cdEstoque);
			estoques.add(estoque);
		}
		return estoques;
	}

}
