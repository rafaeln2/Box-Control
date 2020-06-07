package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import GetConnection.GetConnection;
import dao.ProdutoDAO;
import entity.Produto;

public class ProdutoImp implements ProdutoDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Produto produto) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('produto_cdproduto_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into produto(cdproduto, descr, valor, marca, um) VALUES (?, ?, ?, ?, ?)");
		stm.setInt(1, id);
		stm.setString(2, produto.getDesc());
		stm.setFloat(3, produto.getValor());
		stm.setString(4, produto.getMarca());
		stm.setString(5, produto.getUm());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdProduto) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from produto where cdproduto = (?) order by cdproduto");
		stm.setInt(1, cdProduto);

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
	public void update(Integer cdProduto, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE produto SET descr = (?) where cdproduto = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdProduto);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdProduto) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from produto where cdproduto = (?)");
		stm.setInt(1, cdProduto);
		stm.executeUpdate();
	}

	@Override
	public Collection<Produto> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from produto order by cdproduto");
		rs = stm.executeQuery();

		Collection<Produto> produtos = new ArrayList<>();

		while(rs.next()) {
			Integer cdproduto = rs.getInt("CDPRODUTO");
			String descr = rs.getString("DESCR");
			Float valor = rs.getFloat("VALOR");
			String marca = rs.getString("MARCA");
			String um = rs.getString("UM");

			produtos.add(new Produto(cdproduto, descr, valor, marca, um));
		}
		return produtos;
	}

}
