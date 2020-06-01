package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ConnectJDBC.*;
import DAO.*;
import Entity.*;

public class Principal {
		public static void main(String[] args) {
			Connection conn = null;
			
			try {
				Class.forName("org.postgresql.Driver");

				conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin"); 
				
				/* execute seu código
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
					System.out.println("ERROR");
				}
			}
		}
}
