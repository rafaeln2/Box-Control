package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		carrinho.setCdcarrinho(id);		

		stm.executeUpdate();

	}

	@Override
	public Carrinho read(Integer idCarrinho) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		
		stm = conn.prepareStatement("select * from carrinho where cdcarrinho = (?)");
		stm.setInt(1, idCarrinho);

		rs = stm.executeQuery();

		while(rs.next()) {
			System.out.printf("cdcarrinho: %d, %n cdfuncionario: %d, %n cdvenda: %d, %n cdproduto: %d, %n quantidade: %d, %n nu_caixa: %d, %n tipo_pagamento: %s" ,
					rs.getInt("cdcarrinho"), rs.getInt("cdfuncionario"), rs.getInt("cdvenda"), rs.getInt("cdproduto"), rs.getInt("quantidade"), rs.getInt("nu_caixa"), rs.getString("tipo_pagamento"));

			//System.out.println("nivelacesso: " + rs.getInt("nivelacesso")+ ", ");
			//System.out.println("nm_cargo: " + rs.getString("nm_cargo")+", ");
		};
		return null;
	}

	@Override
	public void update(Integer cdCarrinho, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE carrinho SET  = (?) where cdcarrinho = (?)");

		stm.setString(1, toUpdate);
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

		Collection<Cargo> cargos= new ArrayList<>();

		while(rs.next()) {
			Integer cdcargo = rs.getInt("cdcargo");
			Integer nivelacesso = rs.getInt("nivelacesso");
			String nm_cargo = rs.getString("nm_cargo");

			cargos.add(new Cargo(cdcargo, nivelacesso, nm_cargo));
		}
		return null;
	}

}
