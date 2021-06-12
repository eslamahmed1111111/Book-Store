import java.sql.*;


// public void connection.rollback(): Drops all changes made since the previous commit/rollback.

public class Database {
	public static enum PRIVILEGE{MANAGER,CUSTOMER};
	private Database instance;
	private String userName = "admin";
	private String password = "admin";
	private Connection connection;
	private Statement statement;


	private Database(){
		try {
			// get a connection to database.
			connection = DriverManager.getConnection("",userName,password);
			statement = connection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Database getInstance(){
		if(instance == null) instance = new Database();
		return instance;
	}

	public void executeQuery(String query){
		try {
			statement.executeUpdate(query);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public ResultSet getData(String query){
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
		}catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return resultSet;
	}

	public void CloseConnection(){
		try {
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
