package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.CarrinhoDAO;
import Entity.Cargo;
import Entity.Carrinho;

public class CarrinhoImp implements CarrinhoDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Carrinho carrinho) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		sttm = conn.createStatement();
		rs = sttm.executeQuery("select nextval('carrinho_cdcarrinho_seq')");
		rs.next();

		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into carrinho(cdcarrinho, cdfuncionario, cdvenda, cdproduto, quantidade, nu_caixa, tipo_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?)");

		stm.setInt(1, id);
		stm.setInt(2, carrinho.getCdFuncionario());
		stm.setInt(3, carrinho.getCdVenda());
		stm.setInt(4, carrinho.getCdProduto());
		stm.setInt(5, carrinho.getQuantidade());
		stm.setInt(6, carrinho.getNu_caixa());
		stm.setString(7, carrinho.getTipoPagamento());

		stm.executeUpdate();
	}
	
	@Override
	public void read(Integer idCarrinho) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

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
	public void update(Integer cdCarrinho, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE carrinho SET cdvenda = (?) where cdcarrinho = (?)");

		stm.setInt(1, Integer.parseInt(toUpdate));
		stm.setInt(2, cdCarrinho);

		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdCarrinho) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from carrinho where cdcarrinho = (?)");
		stm.setInt(1, cdCarrinho);
		stm.executeUpdate();
	}

	@Override
	public Collection<Carrinho> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from cargo order by cdcargo");

		rs = stm.executeQuery();

		Collection<Carrinho> carrinhos = new ArrayList<>();

		while(rs.next()) {
			Integer cdCarrinho = rs.getInt("cdcarrinho");
			Integer cdFuncionario = rs.getInt("cdfuncionario");
			Integer cdvenda = rs.getInt("cdvenda");
			Integer cdProduto = rs.getInt("cdproduto");
			Integer quantidade = rs.getInt("quantidade");
			Integer nuCaixa = rs.getInt("nu_caixa");
			String tipoPagamento = rs.getString("tipo_pagamento");
			
			carrinhos.add(new Carrinho(cdCarrinho, cdFuncionario, cdvenda, cdProduto, quantidade, nuCaixa, tipoPagamento));
		}
		return carrinhos;
	}

}
