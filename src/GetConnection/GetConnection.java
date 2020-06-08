package GetConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
		
	public Connection getConnection () throws Exception {
		
		Connection conn = null;

		try {
			String url = "jdbc:postgresql://localhost/banco_aps";
			String username ="postgres";
			String password = "Bernardo@1";
			
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(url, username, password); 
			return conn;
			
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		return null;
	}
}
