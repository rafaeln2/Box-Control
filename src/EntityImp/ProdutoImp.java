package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Produto;
import EntityDAO.ProdutoDAO;
import GetConnection.GetConnection;

public class ProdutoImp implements ProdutoDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Produto produto) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();

		stm = conn.prepareStatement("insert into produto(descr, valor, marca) VALUES (?, ?, ?)");
		stm.setString(1, produto.getDesc());
		stm.setFloat(2, produto.getValor());
		stm.setString(3, produto.getMarca());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdproduto) from produto;");
		rs.next();
		int cdProduto = rs.getInt(1);
		produto.setCdProduto(cdProduto);	
		}

	@Override
	public void read(int cdProduto) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
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
	public void update(int cdProduto, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE produto SET descr = (?) where cdproduto = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdProduto);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdProduto) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from produto where cdproduto = (?)");
		stm.setInt(1, cdProduto);
		stm.executeUpdate();
	}

	@Override
	public Collection<Produto> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from produto order by cdproduto");
		rs = stm.executeQuery();

		Collection<Produto> produtos = new ArrayList<>();

		while(rs.next()) {
			String descr = rs.getString("DESCR");
			Float valor = rs.getFloat("VALOR");
			String marca = rs.getString("MARCA");
			produtos.add(new Produto(descr, valor, marca));
		}
		return produtos;
	}

}
