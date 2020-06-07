package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ConnectJDBC.*;
import dao.*;
import entity.*;

public class Principal {
		public static void main(String[] args) {
			Connection conn = null;
			
			try {
				Class.forName("org.postgresql.Driver");

				conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin"); 
				
				Cargo c1 = new Cargo(1, "Digitador");
				
				CargoDAO cargo = new CargoImp();
				
				cargo.read(5);
				
				
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
