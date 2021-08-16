package com.javatrain.Project0;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBActionsTest {

	@Test
	void testGetAccountBalance() throws SQLException {
		double actualBalance = 0.0;
		double expectedResult = 2500;
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		actualBalance = dbActions.getAccountBalance(1002);
		
		// Assert
		assertEquals(expectedResult, actualBalance);
		
		//fail("Not yet implemented");
	}

	@Test
	void testPostNewBalance() throws SQLException {
		boolean expectedResult = true;
		boolean actualResult;
		
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		actualResult = dbActions.postNewBalance(1002, 10000);
		
		// Assert
		assertEquals(expectedResult, actualResult);
		
		//fail("Not yet implemented");
	}

	@Test
	void testPostTransfer() throws SQLException {
		boolean expectedBoolVal = true;
		boolean actualBoolVal;
		
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		actualBoolVal = dbActions.postTransfer(1002, 12000.0, 1004);
		
		// Assert
		assertEquals(expectedBoolVal, actualBoolVal);
		// fail("Not yet implemented");
	}

	@Test
	void testAcceptTransfer() throws SQLException {
		double actualResult;
		double expectedResult = 12000;
		
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		actualResult = dbActions.acceptTransfer(1002, 8);
		
		// Assert
		assertEquals(expectedResult, actualResult);
		
		//fail("Not yet implemented");
	}

	@Test
	void testApproveCustAcctApplication() throws SQLException {
		boolean expectedBoolVal = true;
		boolean actualBoolVal;
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		actualBoolVal = dbActions.approveCustAcctApplication(15);
		
		// Assert
		assertEquals(expectedBoolVal, actualBoolVal);
		
		//fail("Not yet implemented");
	}

	void testLoadCustomerAccountApplications() throws SQLException {
		String sqlQry;
		Date nowDate;
		List<CAColumn> expectedResult = new 
				ArrayList<CAColumn>(1);
		int i;
		
		// Arrange
		DBActions dbActions = new DBActions();
		
		// Act
		DBConnection dbconn = new DBConnection();
		Statement statement = dbconn.getStatementObj();
		sqlQry = "SELECT * FROM bankcaccountapplications";
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		// Set size
		for(i=0; resultSet.next(); i++) ;
		List<CAColumn> applicationList = new ArrayList<CAColumn>(i);
		
		// return cursor back to beginning of results
		resultSet = statement.executeQuery(sqlQry);
		
		while(resultSet.next()) {
			applicationList.add(new CAColumn(resultSet.getDate(1),
					resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5),
					resultSet.getInt(6)));
		}
		expectedResult.add(new CAColumn(new Date(),
				"Isodor", "Gunsberg", "3023334331",
				"111 N Quick Dr, Williams AZ", 16));
		// Assert
		//assertEquals(applicationList,);
		
	}
	void testDenyCustAcctApplication() throws SQLException {
		
		// Arrange
		
		// Act
		
		// Assert
	}
		
		
		
	
}
