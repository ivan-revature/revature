package com.javatrain.Project0;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;

public class DBActions {

	public List<CAColumn> loadCustomerAccountApplications() throws SQLException {
		
		int i = -1;
		String sqlQry;
		DBConnection dbconn = new DBConnection();
		Statement statement = dbconn.getStatementObj();
		sqlQry = "SELECT * FROM bankaccountapplications";
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		for(i=0; resultSet.next(); i++) ;
		List<CAColumn> applicationList = new ArrayList<CAColumn>(i);
		resultSet = statement.executeQuery(sqlQry);
		
		while(resultSet.next()) {
			
			applicationList.add(new CAColumn(resultSet.getDate(1),
					resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5),
					resultSet.getInt(6)));
		}
		return applicationList;
	}
	
	public double getAccountBalance(int custNum)
		throws SQLException {
		Date javaDate;
		long timeInMilliSeconds;
		double balAmount;
		PreparedStatement prepStatement;
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		String sqlQry = "SELECT * FROM currentaccount "
				+ "WHERE customerNumber = " + custNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		if( resultSet.next() ) {
			// account found
			// log transaction before
			// exiting function
			
			javaDate = new Date();
			timeInMilliSeconds = javaDate.getTime();
			java.sql.Date nowDate = new
					java.sql.Date(timeInMilliSeconds);
			balAmount = resultSet.getDouble(2);
			sqlQry = "INSERT INTO transactionLog "
					+ "(accountNumber, "
					+ "transactionType, "
					+ "accountBalance, "
					+ "transactionAmount, "
					+ "transactionDate, "
					+ "isValid) VALUES (?, ?, ?,"
					+ "?, ?, ?)";
			prepStatement = dbConn.getPreparedStatement(sqlQry);
			prepStatement.setInt(1, custNum);
			prepStatement.setString(2, "balanceQuery");
			prepStatement.setDouble(3, balAmount);
			prepStatement.setDouble(4, -1.0);
			prepStatement.setDate(5, nowDate);
			prepStatement.setBoolean(6, true);
			prepStatement.execute();
			dbConn.closeConnection();
			return balAmount;
		} else
			dbConn.closeConnection();
			System.out.println("getAccountBalance didn't "
					+ "find account number.");
			return 0.00;
	}
	
	public boolean postNewBalance(int custNum, double newBal )
			throws SQLException {
			PreparedStatement prepStatement;
			Date javaDate;
			long timeInMilliSeconds;
			DBConnection dbConn = new DBConnection();
			String sqlQry = "UPDATE currentaccount "
					+ "SET accountBalance = "
					+ newBal + " " 
					+ "WHERE customerNumber=" + custNum;
			Statement statement = dbConn.getStatementObj();
			System.out.println("Debug print: " + newBal);
			statement.execute(sqlQry);
			javaDate = new Date();
			timeInMilliSeconds = javaDate.getTime();
			java.sql.Date nowDate = new
					java.sql.Date(timeInMilliSeconds);
			sqlQry = "INSERT INTO transactionLog "
					+ "(accountNumber, "
					+ "transactionType, "
					+ "accountBalance, "
					+ "transactionAmount, "
					+ "transactionDate, "
					+ "isValid) VALUES (?, ?, ?,"
					+ "?, ?, ?)";
			
			prepStatement = dbConn.getPreparedStatement(sqlQry);
			prepStatement.setInt(1, custNum);
			prepStatement.setString(2, "deposit");
			prepStatement.setDouble(3, newBal);
			prepStatement.setDouble(4, newBal);
			prepStatement.setDate(5, nowDate);
			prepStatement.setBoolean(6, true);
			prepStatement.execute();
			dbConn.closeConnection();
			return true;
	}
	
	public boolean postTransfer(int srcAcct,
			double tranfAmt, int destAcct) throws
			SQLException {
		DBConnection dbConn = new DBConnection();
		long timeInMilliSeconds;
		String sqlQry = "INSERT INTO transactionsPending "
				+ "(sourceAccount, destinationAccount, "
				+ "transferAmount, transferDate) "
				+ "VALUES(?, ?, ?, ?)";
		PreparedStatement prepStatement = 
				dbConn.getPreparedStatement(sqlQry);
		// Get today's date for 'transactionDate' field
		Date javaDate = new Date();
	    timeInMilliSeconds = javaDate.getTime();
	    java.sql.Date nowDate = new
	    		java.sql.Date(timeInMilliSeconds);
	    prepStatement.setInt(1, srcAcct);
	    prepStatement.setInt(2, destAcct);
		prepStatement.setDouble(3, tranfAmt);
		prepStatement.setDate(4, nowDate);
		prepStatement.execute();
		if( prepStatement.getUpdateCount() > 0 ) {
			sqlQry = "INSERT INTO transactionLog "
					+ "(accountNumber, "
					+ "transactionType, "
					+ "accountBalance, "
					+ "transactionAmount, "
					+ "transactionDate, "
					+ "isValid) VALUES (?, ?, ?,"
					+ "?, ?, ?)";
			prepStatement = dbConn.getPreparedStatement(sqlQry);
			prepStatement.setInt(1, srcAcct);
			prepStatement.setString(2, "transfer");
			prepStatement.setDouble(3, tranfAmt);
			prepStatement.setDouble(4, tranfAmt);
			prepStatement.setDate(5, nowDate);
			prepStatement.setBoolean(6, true);
			prepStatement.execute();
			return true;
		}
		else
			return false;
	}
	
	public double acceptTransfer(int custNum, int transfID )
		throws SQLException {
		PreparedStatement prepStatement;
		// Get today's date for 'transactionDate' field
		Date javaDate = new Date();
		java.sql.Date nowDate;
	    long timeInMilliSeconds;
		double transfAmt;
		DBConnection dbConn = new DBConnection();
		String sqlQry = "SELECT transferAmount "
				+ "FROM transactionspending "
				+ "WHERE id = " + transfID;
		Statement statement = dbConn.getStatementObj();
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		if( resultSet.next() ) {
			// found transfID
			transfAmt = resultSet.getDouble(1);
			prepStatement = dbConn.getPreparedStatement(sqlQry);
			timeInMilliSeconds = javaDate.getTime();
			nowDate = new java.sql.Date(timeInMilliSeconds);
			sqlQry = "INSERT INTO transactionLog "
						+ "(accountNumber, "
						+ "transactionType, "
						+ "accountBalance, "
						+ "transactionAmount, "
						+ "transactionDate, "
						+ "isValid) VALUES (?, ?, ?,"
						+ "?, ?, ?)";
				prepStatement = dbConn.getPreparedStatement(sqlQry);
				prepStatement.setInt(1, custNum);
				prepStatement.setString(2, "transferAccept");
				prepStatement.setDouble(3, transfAmt);
				prepStatement.setDouble(4, transfAmt);
				prepStatement.setDate(5, nowDate);
				prepStatement.setBoolean(6, true);
				prepStatement.execute();
				sqlQry = "DELETE FROM transactionsPending "
						+ "WHERE id = " + transfID;
				statement.execute(sqlQry);
				if( statement.getUpdateCount() > 0 ) {
					System.out.println("Transfer "
						+ "was accepted, logged "
						+ "and removed from "
						+ "pending transactions "
						+ "table.");
					dbConn.closeConnection();
					return transfAmt;
				} else {
					System.out.println(
						"Pending transaction "
						+ "was not removed from "
						+ "table.");
					return transfAmt;
				}
		} else {
			// transfID was not found
			System.out.println("acceptTransfer "
				+ "was not able to find the "
				+ "specified transaction ID.");
			return 0;
		}
	}
	public void viewAccountsBalance(int custNum) 
			throws SQLException {
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		String sqlQry = "SELECT * FROM currentaccount "
				+ "WHERE customerNumber = " + custNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		System.out.print("\nCurrent account balance: ");
		while( resultSet.next() ) {
			System.out.println(resultSet.getDouble(2));
		}
		
		sqlQry = "SELECT * FROM savingsaccount "
				+ "WHERE customerNumber = " + custNum;
		resultSet = statement.executeQuery(sqlQry);
		
		System.out.print("\nSavings account balance: ");
		while( resultSet.next() ) {
			System.out.println(resultSet.getDouble(2));
		}
		
		sqlQry = "SELECT * FROM retirementaccount "
				+ "WHERE customerNumber = " + custNum;
		resultSet = statement.executeQuery(sqlQry);
		
		System.out.print("\nRetirement account balance: ");
		while( resultSet.next() ) {
			System.out.println(resultSet.getDouble(2));
		}
		dbConn.closeConnection();
	}
	
	public void viewCustomerAccounts(int acctNum)
		throws SQLException {
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		String sqlQry = "SELECT "
				+ "accountBalance, "
				+ "accountStartDate "
				+ "FROM currentaccount "
				+ "WHERE customerNumber = "
				+ acctNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		System.out.println("\nCurrent account: ");
		
		while( resultSet.next() ) {
			System.out.println("\n"
				+ "Balance: " + resultSet.getDouble(1)
				+ "\nOpen since: " + resultSet.getDate(2));
		}
		
		sqlQry = "SELECT "
				+ "accountBalance, "
				+ "accountStartDate "
				+ "FROM savingsaccount "
				+ "WHERE customerNumber = "
				+ acctNum;
		resultSet = statement.executeQuery(sqlQry);
		
		System.out.println("\nSavings account: ");
		while( resultSet.next() ) {
			System.out.println("\n"
				+ "Balance: " +resultSet.getDouble(1)
				+ "\nOpen since: " + resultSet.getDate(2));
		}
		
		sqlQry = "SELECT "
				+ "accountBalance, "
				+ "accountStartDate "
				+ "FROM retirementaccount "
				+ "WHERE customerNumber ="
				+ acctNum;
		resultSet = statement.executeQuery(sqlQry);
		
		System.out.println("\nRetirement account: ");
		while( resultSet.next() ) {
			System.out.println("\nBalance: "
				+ resultSet.getDouble(1)
				+ "\nOpen since: " + resultSet.getDate(2));
		}
		
		dbConn.closeConnection();
	}
	
	public void viewTransactionsPending(int custNum)
		throws SQLException {
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		String sqlQry = "SELECT id, sourceAccount, "
				+ "destinationAccount, "
				+ "transferAmount, "
				+ "transferDate FROM "
				+ "transactionsPending "
				+ "WHERE destinationAccount = "
				+ custNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		System.out.println("\nTransfers pending: ");
		while( resultSet.next() ) {
			System.out.println("\n"
					+ resultSet.getInt(1)
					+ " " + resultSet.getInt(2)
					+ " " + resultSet.getInt(3)
					+ " " + resultSet.getDouble(4)
					+ " " + resultSet.getDate(5));
		}
		dbConn.closeConnection();
	}
	
	public List<BAColumn> loadBankAccountApplications() throws SQLException {
		int i = -1;
		String sqlQry;
		DBConnection dbconn = new DBConnection();
		Statement statement = dbconn.getStatementObj();
		sqlQry = "SELECT * FROM bankcaccountapplications";
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		for(i=0; resultSet.next(); i++) ;
		List<BAColumn> applicationList = new ArrayList<BAColumn>(i);
		
		// return cursor back to beginning of results
		resultSet = statement.executeQuery(sqlQry);
		
		while(resultSet.next()) {
			
			applicationList.add(new BAColumn(resultSet.getInt(1),
					resultSet.getString(2), resultSet.getInt(3),
					resultSet.getDouble(4)));
		}
		return applicationList;
	}

	public boolean approveCustAcctApplication(int appNum)
			throws SQLException {
		long timeInMilliSeconds;
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		PreparedStatement prepStatement;
		String sqlQry = "SELECT * FROM "
				+ "bankaccountapplications WHERE applicationNum"
				+ "= " + appNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		if(resultSet != null) {
			if(resultSet.next()) { // application number exists
				// Get today's date for 'open since' field
				Date javaDate = new Date();
			    timeInMilliSeconds = javaDate.getTime();
			    java.sql.Date nowDate = new
			    		java.sql.Date(timeInMilliSeconds);
			    
				sqlQry = "INSERT INTO bankcustomer (fName, lName,"
						+ "startingDate, phone, address, accountsActive) "
						+ "VALUES(?, ?, ?, ?, ?, ?)";
				prepStatement = dbConn.getPreparedStatement(sqlQry);
				prepStatement.setString(1, resultSet.getString(2));
				prepStatement.setString(2, resultSet.getString(3));
				prepStatement.setDate(3, nowDate);
				prepStatement.setString(4, resultSet.getString(4));
				prepStatement.setString(5, resultSet.getString(5));
				prepStatement.setInt(6, 0);
				prepStatement.execute();
				//prepStatement.getUpdateCount() >= 1
						
				/*		STR_TO_DATE(\'"
						\',\'%Y-%m-%d\'), 
				*/
			}
			sqlQry = "DELETE FROM bankaccountapplications "
					+ "WHERE applicationNum = " + appNum;
			
			statement.execute(sqlQry);
			dbConn.closeConnection();
			return true;
		}
		else {
			System.out.println("Such account application number was not found."
					+ " Please try again.");
			return false;
		}
	}
	
	public boolean denyCustAcctApplication(int appNum)
			throws SQLException {
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		
		try {
			String sqlQry = "DELETE FROM bankaccountapplications "
						+ "WHERE applicationNum = " + appNum;
			statement.execute(sqlQry);
			
			if(statement.getUpdateCount() > 0) {
				dbConn.closeConnection();
				return true;
			}
			else {
				dbConn.closeConnection();
				return false;
			}
		} catch(Exception e) {
			System.out.println("Error caught in DBActions: " + e.getMessage());
			return false;
		}
	}
	
	public boolean approveBankAcctApplication(int appNum)
			throws SQLException {
		long timeInMilliSeconds;
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		String sqlQry = "SELECT * FROM "
				+ "bankcaccountapplications WHERE applicationNum"
				+ "= " + appNum;
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		// Get today's date for 'open since' field
		Date javaDate = new Date();
	    timeInMilliSeconds = javaDate.getTime();
	    java.sql.Date nowDate = new
	    		java.sql.Date(timeInMilliSeconds);
	    
		if(resultSet != null) {
			if(resultSet.next()) { // application number exists
				switch(resultSet.getString(2)) {
				case "current":
					sqlQry = "INSERT INTO currentaccount "
							+ "(customerNumber, "
							+ "accountBalance, "
							+ "active, "
							+ "accountStartDate) "
							+ "VALUES("
							+ resultSet.getInt(3) + ", "
							+ resultSet.getDouble(4) + ", "
							+ "1," + "STR_TO_DATE(\'"
							+ nowDate + "\',\'%Y-%m-%d\')"
							+ ")";
					break;
				case "savings":
					sqlQry = "INSERT INTO savingsaccount "
							+ "(customerNumber, accountBalance, "
							+ "active, accountStartDate) "
							+ "VALUES("
							+ resultSet.getString(3) + ", "
							+ resultSet.getDouble(4) + ", "
							+ "1," + "STR_TO_DATE(\'"
							+ nowDate + "\',\'%Y-%m-%d\')"
							+ ")";
					break;
				case "retirement":
					sqlQry = "INSERT INTO savingsaccount "
							+ "(customerNumber, accountBalance, "
							+ "active, accountStartDate) "
							+ "VALUES("
							+ resultSet.getString(3) + ", "
							+ resultSet.getDouble(4) + ", "
							+ "1," + "STR_TO_DATE(\'"
							+ nowDate + "\',\'%Y-%m-%d\')"
							+ ")";
					break;
				}
				statement.execute(sqlQry);
			}
			// delete application that was just approved
			// from applications table
			sqlQry = "DELETE FROM bankcaccountapplications "
					+ "WHERE applicationNum = " + appNum;
			
			statement.execute(sqlQry);
			if( statement.getUpdateCount() >= 1 )
				System.out.println("applications table updated!");
			dbConn.closeConnection();
			return true;
		}
		else {
			System.out.println("Such account application number was not found."
					+ " Please try again.");
			return false;
		}
	}
	
	public boolean submitCAccountApplication(int custNum, double startBal) 
			throws SQLException {
		DBConnection dbConn = new DBConnection();
		String sqlQry = "INSERT INTO bankcaccountapplications "
				+ "(accountType, customerNumber,"
				+ "startingBalance) " 
				+ "VALUES (?, ?, ?)";
		PreparedStatement prepStatement = dbConn.getPreparedStatement(sqlQry);
		prepStatement.setString(1, "current");
		prepStatement.setInt(2, custNum);
		prepStatement.setDouble(3, startBal);
		prepStatement.execute();
		if( prepStatement.getUpdateCount() > 0 )
			return true;
		else
			return false;
	}
	
	public boolean submitSAccountApplication(int custNum, double startBal) 
			throws SQLException {
		DBConnection dbConn = new DBConnection();
		String sqlQry = "INSERT INTO bankcaccountapplications "
				+ "(accountType, customerNumber,"
				+ "startingBalance) " 
				+ "VALUES (?, ?, ?)";
		PreparedStatement prepStatement = dbConn.getPreparedStatement(sqlQry);
		prepStatement.setString(1, "savings");
		prepStatement.setInt(2, custNum);
		prepStatement.setDouble(3, startBal);
		prepStatement.execute();
		if( prepStatement.getUpdateCount() > 0 )
			return true;
		else
			return false;
	}
	
	public boolean submitRAccountApplication(int custNum, double startBal) 
			throws SQLException {
		DBConnection dbConn = new DBConnection();
		String sqlQry = "INSERT INTO bankcaccountapplications "
				+ "(accountType, customerNumber,"
				+ "startingBalance) " 
				+ "VALUES (?, ?, ?)";
		PreparedStatement prepStatement = dbConn.getPreparedStatement(sqlQry);
		prepStatement.setString(1, "retirement");
		prepStatement.setInt(2, custNum);
		prepStatement.setDouble(3, startBal);
		prepStatement.execute();
		if( prepStatement.getUpdateCount() > 0 )
			return true;
		else
			return false;
	}
	
	public boolean authenticate(String usrNom, String usrPwd,
			Controller ctrl) throws SQLException {
		DBConnection dbConn = new DBConnection();
		Statement statement = dbConn.getStatementObj();
		
		String sqlQry = "SELECT customerNumber, " +
				"fName, lName FROM bankcustomer";
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		while( resultSet.next() ) {
			if( resultSet.getString(2).equals(usrNom)
					&& resultSet.getString(3).equals(usrPwd) ) {
				ctrl.customerNumber = resultSet.getInt(1);
				dbConn.closeConnection();
				return true;
			}
		}
		dbConn.closeConnection();
		return false;
	}
}
