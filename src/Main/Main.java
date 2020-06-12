package Main;

import GetConnection.GetConnection;
import Views.SystemView;

public class Main {

	public static void main(String[] args) {
		
		SystemView systemView = new SystemView();
		systemView.setVisible(true);
		
		GetConnection getConnection = new GetConnection();
		
		try {
			getConnection.getConnection();
			System.out.println("Connected to database !");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
