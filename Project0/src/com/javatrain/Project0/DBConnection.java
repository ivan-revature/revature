package com.javatrain.Project0;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBConnection  {
	Connection conn;
	public DBConnection() throws SQLException {
		//Step 1: load the driver
		//Class.forName("jdbc:mysql://localhost:3306/project0");
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
