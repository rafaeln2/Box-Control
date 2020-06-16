package Main;

import GetConnection.GetConnection;
import Views.SystemView;

public class Main {

	public static void main(String[] args) {	
		try {	
			SystemView systemView = new SystemView();
			systemView.setVisible(true);
			
			GetConnection getConnection = new GetConnection();	
			getConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}