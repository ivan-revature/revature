import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		// Step 1: load the driver
		//Class.forName("jdbc:mysql://localhost:3306/project0");
		// Step 2: Create connection object
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "mySQL1");
		// Step 3: Create statement object
		Statement statement = conn.createStatement();
		
		// Step 4: Execute query
		//statement.executeQuery("INSERT INTO bankuser " + "('username', 'password', 'name') VALUES ('guest','pwd','abc')");
		statement.executeUpdate("INSERT INTO bankuser (username, password, name) VALUES ('guest','pwd','abc')");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM bankuser");
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("username"));
			System.out.println(resultSet.getString("password"));
			System.out.println(resultSet.getString("name"));
			//System.out.println(resultSet.getString(3));
		}
		
		System.out.println("Total: " + resultSet.getRow());
		// Step 5: Close the connection
		conn.close();
		
	}

}
