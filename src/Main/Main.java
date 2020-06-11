package Main;

import GetConnection.GetConnection;
import views.SystemView;

public class Main {

	public static void main(String[] args) {
		GetConnection getConnection = new GetConnection();
		SystemView systemView = new SystemView();
		systemView.setVisible(true);
		//MenuMercado menuMercado = new MenuMercado();
	
		try {
			getConnection.getConnection();
			System.out.println("Connected to database !");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
