

import java.sql.*;

public class Driver {
	
	public Statement signIn(String userName, String password) {
		Connection myConnection;
		Statement myStatement = null;
		try {
			// get a connection to database.
			myConnection = DriverManager.getConnection("");
			myStatement = myConnection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return myStatement;
	}

	public Statement signUp() {
		
		
	}
	
}
