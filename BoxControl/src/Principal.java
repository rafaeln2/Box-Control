import java.sql.*;

import ConnectJDBC.PessoaImp;
import DAO.PessoaDAO;
import Entity.Pessoa;

public class Principal {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "postgres", "danield5"); 
			//conn.setAutoCommit(false);
			
			
			PessoaDAO pessoa = new PessoaImp();
			
			//Pessoa p2 = new Pessoa("09829368939", "Danleho", "20/06/1997");
			pessoa.find("09829368939");
			//pessoa.update( "FERNANDOOO");
			
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("ERROR");
		}
	}
} 
