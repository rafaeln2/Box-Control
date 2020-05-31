import java.sql.*;

import ConnectJDBC.CargoImp;
import ConnectJDBC.CarrinhoImp;
import ConnectJDBC.PessoaImp;
import DAO.CargoDAO;
import DAO.CarrinhoDAO;
import DAO.PessoaDAO;
import Entity.Cargo;
import Entity.Carrinho;

public class Principal {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "postgres", "danield5"); 
			
			PessoaDAO pessoa = new PessoaImp();
			pessoa.read(2);
			/*
			 * 
			 * 
			 * 
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
} 
