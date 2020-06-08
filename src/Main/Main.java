package Main;

import GetConnection.GetConnection;

public class Main {

	public static void main(String[] args) {
		GetConnection getConnection = new GetConnection();
		try {
			getConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
