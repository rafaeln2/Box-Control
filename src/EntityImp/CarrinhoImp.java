package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Carrinho;
import EntityDAO.CarrinhoDAO;
import GetConnection.GetConnection;

public class CarrinhoImp implements CarrinhoDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Carrinho carrinho) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement("insert into carrinho(cdfuncionario, cdvenda, cdproduto, quantidade, tipo_pagamento) VALUES (?, ?, ?, ?, ?)");

		stm.setInt(1, carrinho.getCdFuncionario());
		stm.setInt(2, carrinho.getCdVenda());
		stm.setInt(3, carrinho.getCdProduto());
		stm.setInt(4, carrinho.getQuantidade());
		stm.setString(5, carrinho.getTipoPagamento());

		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdcarrinho) from carrinho;");
		rs.next();
		int cdCarrinho = rs.getInt(1);
		carrinho.setCdcarrinho(cdCarrinho);
	}
	
	@Override
	public void read(int idCarrinho) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from carrinho where cdcarrinho = (?)");
		stm.setInt(1, idCarrinho);

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
	public void update(int cdCarrinho, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE carrinho SET cdvenda = (?) where cdcarrinho = (?)");

		stm.setInt(1, Integer.parseInt(toUpdate));
		stm.setInt(2, cdCarrinho);

		stm.executeUpdate();
	}

	@Override
	public void delete(int cdCarrinho) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from carrinho where cdcarrinho = (?)");
		stm.setInt(1, cdCarrinho);
		stm.executeUpdate();
	}

	@Override
	public Collection<Carrinho> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from cargo order by cdcargo");

		rs = stm.executeQuery();

		Collection<Carrinho> carrinhos = new ArrayList<>();

		while(rs.next()) {
			int cdFuncionario = rs.getInt("cdfuncionario");
			int cdvenda = rs.getInt("cdvenda");
			int cdProduto = rs.getInt("cdproduto");
			int quantidade = rs.getInt("quantidade");
			String tipoPagamento = rs.getString("tipo_pagamento");
			carrinhos.add(new Carrinho(cdFuncionario, cdvenda, cdProduto, quantidade, tipoPagamento));
		}
		return carrinhos;
	}

}
