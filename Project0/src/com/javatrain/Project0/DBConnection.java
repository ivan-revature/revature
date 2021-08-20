package com.javatrain.Project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection  {
	Connection conn;
	public DBConnection() throws SQLException, ClassNotFoundException {
		//Step 1: load the driver
		Class.forName("com.mysql.jdbc.Driver");
		// Step 2: Create connection object
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "mySQL1");
	}
	
	public Statement getStatementObj() throws SQLException {
		return conn.createStatement();
	}
	
	public PreparedStatement getPreparedStatement(String statementSQL) throws SQLException {
		return conn.prepareStatement(statementSQL);
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
}
