package com.javatrain.Project0;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Date;

public class Controller {
	int customerNumber;
	public static void main(String[] args) throws SQLException {
		int appModeChoice = 0;
		boolean unregisteredUserChoice;
		int appUserChoice = 0;
		int emplCommand = 0;
		
		String authQuestion;
		String username;
		String password;
		
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		
		System.out.println("Welcome to the Bank application!");
		
		do {
			System.out.println("\nSelect from the following options: ");
			System.out.println("\nI'd like to log in as: ");
			System.out.println("\n1. Unregistered user");
			System.out.println("2. Employee");
			System.out.println("3. Customer");
			System.out.println("4. System");
			System.out.println("0. Quit");
			
			appModeChoice = controller.getAppModeChoice(scanner);
			
			switch(appModeChoice) {
			case 1: // User
				unregisteredUserChoice = controller.getActionChoice(scanner);
				if(unregisteredUserChoice)
					System.out.println("\nYour new bank account application "
							+ "was submitted!");
				else
					System.out.println("\nNo action was taken.");
				break;
			case 2: // Employee
				do {
					appUserChoice = controller.employeeMenuSelection(scanner);
					// employee's menu options
					switch(appUserChoice) {
					case 1: // approve/deny customer acct applications
						do {
							controller.viewCustomerAccountApplications();
							System.out.println("\nI'd like to: 1. Approve 2. Deny application (0. to go back)");
							System.out.print("Enter your command (0-2): ");
							emplCommand = scanner.nextInt();
							if( emplCommand == 1 ) {
								System.out.print("Enter customer application "
										+ "number that you would like to approve: ");
								emplCommand = scanner.nextInt();
								controller.approveCustomerAcctApplication(emplCommand);
							} else if(emplCommand == 2) {
								System.out.print("Enter application number that you would like to deny: ");
								emplCommand = scanner.nextInt();
								controller.denyBAcctApplication(emplCommand);
							}
						} while(emplCommand != 0);
						break;
					case 2: // approve/deny bank account applications
						do {
							controller.viewBankAccountApplications();
							System.out.println("\nI'd like to: 1. Approve 2. Deny application (0. to go back)");
							System.out.print("Enter your command (0-2): ");
							emplCommand = scanner.nextInt();
							if( emplCommand == 1 ) {
								System.out.print("Enter customer application "
										+ "number that you would like to approve: ");
								emplCommand = scanner.nextInt();
								controller.approveBankAcctApplication(emplCommand);
							} else if(emplCommand == 2) {
								System.out.print("Enter application number that you would like to deny: ");
								emplCommand = scanner.nextInt();
								controller.denyBAcctApplication(emplCommand);
							}
						} while(emplCommand != 0);
						break;
					case 3: // view customers' accounts
							controller.viewAccountsByCustomer(scanner);
					}
				} while(emplCommand != 0);
				break;
			case 3: // Customer
				System.out.println("\nEnter your user name and password to log in: ");
				System.out.print("User name: ");
				username = scanner.next();
				System.out.print("Password: ");
				password = scanner.next();
				
				try {
					if( controller.authenticateUser(username, password, controller) ) {
						do {
							appUserChoice = controller.customerMenuSelection(scanner);
							switch(appUserChoice) {
							case 1: // customer's menu options
								controller.applyForNewBAccount(scanner,
										controller.customerNumber);
								break;
							case 2:
								controller.viewAcctBal(controller.customerNumber);
								break;
							case 3:
								controller.depositWithdraw(
										scanner, 
										controller.customerNumber);
								break;
							case 4:
								// controller.transfer(controller.customerNumber);
								break;
							}
						} while(appUserChoice != 0);
					} else {
						System.out.println("\nLogin error. Try again.");
					}
				} catch (Exception e) {
					System.out.println("Error while authenticating: " + e.getMessage());
					// Exit app
				}
				break;
			case 4: // System
				
				break;
			case 0:
				//Exit application
			}
		} while(appModeChoice != 0);
			
	}
	
	private int getAppModeChoice(Scanner scanner) {
		int choice = 0;
		choice = scanner.nextInt();
		return choice;
	}
	
	private boolean getActionChoice(Scanner scanner) {
		boolean register = false;
		int actionChoice = 0;
		boolean authentication = true; // delete
		String authQuestion; // delete
		String fname;
		String lname;
		String phone;
		String address;
		
		do {
			
			if(authentication) {
				System.out.print("Would you like to register for a bank account: ");
				register = scanner.nextBoolean();
				if(register) {
					System.out.print("\nFirst name: ");
					fname = scanner.next();
					System.out.print("Last name: ");
					lname = scanner.next();
					System.out.print("Phone number: ");
					phone = scanner.next();
					address = scanner.nextLine();
					System.out.print("Address: ");
					address = scanner.nextLine();
					 
				    
				    
				    Controller controller = new Controller();
				    Date javaDate = new Date();
				    long timeInMilliSeconds = javaDate.getTime();
				    java.sql.Date nowDate = new
				    		java.sql.Date(timeInMilliSeconds);
				    
				    try {
				    controller.submitNewBankAcctApp(fname, lname, phone, address, nowDate);
				    } catch(Exception e) {
				    	System.out.println("Error msg: " + e.getMessage());
				    }
				} else
					return false; // exit
			} else {
				System.out.println("Authentication failed!");
				System.out.print("Would you like to try again? [yes/no]: ");
				authQuestion = scanner.next();
				if(authQuestion == "no")
					actionChoice = 0;
				else
					actionChoice = 1;
			}
		} while(actionChoice != 0);
		return true;
	}
	
	private void submitNewBankAcctApp(String fname, String lname, String ph,
			String addr, java.sql.Date datum) throws SQLException, ClassNotFoundException {
		String updateSQL;
		
		//Step 1: load the driver
		//Class.forName("jdbc:mysql://localhost:3306/project0");
		// Step 2: Create connection object
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "mySQL1");
		// Step 3: Create statement object
		updateSQL = "INSERT INTO bankaccountapplications "
				+ "(applicationDate, firstName, lastName, phone, "
				+ "address) VALUES "
				+ "(?, ?, ?, ?, ?)";
		PreparedStatement prepStatement = conn.prepareStatement(updateSQL);
		prepStatement.setDate(1, datum);
		prepStatement.setString(2, fname);
		prepStatement.setString(3, lname);
		prepStatement.setString(4, ph);
		prepStatement.setString(5, addr);
		// Step 4: Execute query
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		//datum = (date)formatter.format(datum);
		System.out.println("date: " + datum.toString());
		prepStatement.executeUpdate();
		
		conn.close();
	}
	
	private void viewAcctBal(int custNum)
		throws SQLException {
		DBActions dbActions = new DBActions();
		int accountOption;
		
		dbActions.viewAccountsBalance(custNum);
	}
	
	private int customerMenuSelection(Scanner scanner) {
		int choice;
		
		// apply for a new bank account with a starting balance
		System.out.println("\n*** Bank ***");
		System.out.println("\nCustomer's menu");
		System.out.println("\n1. Apply for new bank account");
		System.out.println("2. View account balance");
		System.out.println("3. Withdraw or deposit...");
		System.out.println("4. Transfer funds...");
		System.out.println("5. View transactions pending...");
		
		choice = scanner.nextInt();
		return choice;
	}
	
	private void depositWithdraw(Scanner scanner, int custNum)
		throws SQLException, TransactionException {
		int actionChoice;
		int transfChoice;
		int destNum;
		double transAmt;
		double balance = 0.0;
		boolean flag = false;
		DBActions dbActions = new DBActions();
		BankTransaction bnkTransaction;
		DepositThread depositThread;
		
		BankTransaction bank = new BankTransaction(custNum);
		
		do {
			System.out.println("\nAction menu: ");
			System.out.println("\n1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Transfer");
			System.out.println("4. Accept transfer");
			System.out.println("0. Finish");
			System.out.print("\nWhich account action "
					+ "would you like to perform: ");
			actionChoice = scanner.nextInt();
			switch(actionChoice) {
			case 1:
				System.out.print("\nDeposit amount: ");
				try {
					transAmt =  scanner.nextDouble();
					if( transAmt < 0 )
						throw new TransactionException(1);
					else {
						depositThread = 
						new DepositThread(bank, custNum,
		        			transAmt);
						depositThread.start();
					}
				} catch(TransactionException e) {
					System.out.println("Error: "
			    			+ e.getMessage());
				}
		        
		        break;
			case 2:
				System.out.print("\nWithdraw amount: ");
				try {
					transAmt =  scanner.nextDouble();
					// Validate withdrawal amount
					bnkTransaction = new BankTransaction(custNum);
					balance = bnkTransaction.checkBalance();
					if( (balance - transAmt < 0) )
						throw new TransactionException(1);
					else {
						WithdrawThread withdrawThread = 
							new WithdrawThread(bank, custNum,
									scanner.nextDouble());
						withdrawThread.start();
					}
				} catch(TransactionException e) {
					System.out.println("Error: "
			    			+ e.getMessage());
				}
				break;
			case 3:
				System.out.print("\nDestination account: ");
				destNum = scanner.nextInt();
				do {
					System.out.print("\nTransfer amount: ");
					transAmt = scanner.nextDouble();
					if( transAmt <= 0 ) {
						flag = false;
						System.out.println("\n Transfer "
							+ "amount is invalid.  "
							+ "Please enter a positive "
							+ "amount.");
					} else
						flag = true;
				} while(!flag);
				TransferThread transferThread =
					new TransferThread(bank, custNum, transAmt, destNum);
				transferThread.start();
				break;
			case 4:
				System.out.println("\nMoney transfers pending: ");
				dbActions.viewTransactionsPending(custNum);
				System.out.print("\nTransfer to accept: ");
				transfChoice = scanner.nextInt();
				transAmt = dbActions.acceptTransfer(custNum, transfChoice);
				depositThread = new DepositThread(
						bank, custNum, transAmt);
			    depositThread.start();
			}
		} while(actionChoice != 0);
		
	}
	private void applyForNewBAccount(Scanner scanner, int custNum) 
		throws SQLException {
		int choice = 0;
		double startingBalance;
		DBActions dbActions = new DBActions();
		
		// Get bank account type choice from customer
		System.out.println("\nSelect the account type that "
				+ "you would like to apply for: ");
		System.out.println("1. Current account");
		System.out.println("2. Savings account");
		System.out.println("3. Retirement account");
		choice = scanner.nextInt();
		
		switch(choice) {
		case 1: // current account
			System.out.print("Starting balance: ");
			startingBalance = scanner.nextDouble();
			if(dbActions.submitCAccountApplication(custNum, startingBalance)) {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new current account was "
						+ "submitted successfully!");
			} else {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new current account was "
						+ "not submitted. Please try again "
						+ "later.");
			}
			break;
		case 2: // savings account
			System.out.print("Starting balance: ");
			startingBalance = scanner.nextDouble();
			if(dbActions.submitSAccountApplication(custNum, startingBalance)) {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new savings account was "
						+ "submitted successfully!");
			} else {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new savings account was "
						+ "not submitted. Please try again "
						+ "later.");
			}
			break;
		case 3: // retirement account
			System.out.print("Starting balance: ");
			startingBalance = scanner.nextDouble();
			if(dbActions.submitRAccountApplication(custNum, startingBalance)) {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new retirement account was "
						+ "submitted successfully!");
			} else {
				System.out.println("\n***System message ***");
				System.out.println("\nYour application for "
						+ "a new retirement account was "
						+ "not submitted. Please try again "
						+ "later.");
			}
			break;
		}
	}
	private int employeeMenuSelection(Scanner scanner) {
		int choice;
		// approve or deny application
		
		// view accounts
		
		// view transLog
		System.out.println("\n*** Bank ***");
		System.out.println("\nEmployee's menu");
		System.out.println("\n1. View customer account applications");
		System.out.println("2. View bank account applications");
		System.out.println("3. View bank accounts");
		System.out.println("4. View transactions log");
		
		choice = scanner.nextInt();
		return choice;
	}
	
	private void viewAccountsByCustomer(Scanner scanner)
			throws SQLException {
		DBActions dbActions = new DBActions();
		int acctChoice;
		do {
			//dbActions.viewSavingsAccounts();
			//dbActions.viewRetirementAccounts();
			System.out.print("\nCustomer number: ");
			acctChoice = scanner.nextInt();
			dbActions.viewCustomerAccounts(acctChoice);
		} while(acctChoice != 0);
	}
	
	private void viewCustomerAccountApplications() throws SQLException {
		DBActions dbaction = new DBActions();
		List<CAColumn> customers = dbaction.loadCustomerAccountApplications();
				
		System.out.println("\nApp Date\tName\t\tPhone\t\tAddress\t\tApplication Number\n");
		for(CAColumn list:customers) {
			System.out.println(list.appDate + "\t"
					+ list.lNom.substring(0, 3) + "\t\t" + list.phone + "\t\t"
					+ list.address + "\t\t" + list.appNum);
		}
	}
	
	private void viewBankAccountApplications() throws SQLException {
		DBActions dbaction = new DBActions();
		List<BAColumn> customers 
			= dbaction.loadBankAccountApplications();
				
		System.out.println("\nApp Number\t\tAccountType"
				+ "\t\tCustomerNumber"
				+ "\t\tStartingBalance\n");
		for(BAColumn list:customers) {
			System.out.println(list.applicationNumber
					+ "\t\t\t" + list.accountType
					+ "\t\t\t" + list.customerNumber
					+ "\t\t\t"
					+ list.startingBalance);
		}
	}
	
	private void approveCustomerAcctApplication(int appNum) throws SQLException {
		DBActions dbAction = new DBActions();
		
		if(dbAction.approveCustAcctApplication(appNum)) {
			System.out.println("\n*** System message ***");
			System.out.println("\nYou approved the application.");
		} else {
			System.out.println("\n*** System message ***");
			System.out.println("\nApplication was not approved.");
		}
	}
	
	private void denyBAcctApplication(int appNum) throws SQLException {
		DBActions dbAction = new DBActions();
		if(dbAction.denyCustAcctApplication(appNum)) {
			System.out.println("\n*** System message ***");
			System.out.println("\nYou denied the application.");
		} else {
			System.out.println("\n*** System message ***");
			System.out.println("\nThe application was not successfully "
					+ "denied.  Check if the application number "
					+ "really exists.");
		}
	}
	
	private void approveBankAcctApplication(int appNum) throws SQLException {
		DBActions dbAction = new DBActions();
		
		if(dbAction.approveBankAcctApplication(appNum)) {
			System.out.println("\n*** System message ***");
			System.out.println("\nYou approved the application.");
		} else {
			System.out.println("\n*** System message ***");
			System.out.println("\nApplication was not approved.");
		}
	}
	
	private void denyBankAcctApplication(int appNum) throws SQLException {
		DBActions dbAction = new DBActions();
		if(dbAction.denyCustAcctApplication(appNum)) {
			System.out.println("\n*** System message ***");
			System.out.println("\nYou denied the application.");
		} else {
			System.out.println("\n*** System message ***");
			System.out.println("\nThe application was not successfully "
					+ "denied.  Check if the application number "
					+ "really exists.");
		}
	}
	
	private boolean authenticateUser(String usrName, String passwd,
			Controller ctrl) throws SQLException {
		DBActions dbActions =  new DBActions();
		
		if(dbActions.authenticate(usrName, passwd, ctrl)) {
			return true;
		} else
			return false;
		
		
	}
	
	private java.sql.Date createSqlDate(int year, int month, int day) {

	    // Create a date string with leading zeros for month and day.
	    String dateString = String.format("%d-%02d-%02d", year, month, day);

	    return java.sql.Date.valueOf(dateString);
	}
}
