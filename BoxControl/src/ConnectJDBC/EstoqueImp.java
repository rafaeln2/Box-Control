package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dao.EstoqueDAO;
import entity.Estoque;

public class EstoqueImp implements EstoqueDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Estoque estoque) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('estoque_cdestoque_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into estoque(cdestoque, cdproduto, quantidade) VALUES (?, ?, ?)");
		stm.setInt(1, id);
		stm.setInt(2, estoque.getCdEstoque());
		stm.setInt(3, estoque.getcdProduto());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdEstoque) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

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
	public void update(Integer cdEstoque, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE estoque SET cdproduto = (?) where cdestoque = (?)");
		stm.setInt(1, Integer.parseInt(toUpdate));
		stm.setInt(2, cdEstoque);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdEstoque) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from estoque where estoque = (?)");
		stm.setInt(1, cdEstoque);
		stm.executeUpdate();
		
	}

	@Override
	public Collection<Estoque> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from estoque order by cdestoque");
		rs = stm.executeQuery();

		Collection<Estoque> estoques = new ArrayList<>();

		while(rs.next()) {
			Integer cdEstoque = rs.getInt("CDESTOQUE");
			Integer cdProduto = rs.getInt("CDPRODUTO");
			Integer quantidade = rs.getInt("QUANTIDADE");
		

			estoques.add(new Estoque(cdEstoque, cdProduto, quantidade));
		}
		return estoques;
	}

}
