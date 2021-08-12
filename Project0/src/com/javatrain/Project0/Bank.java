package com.javatrain.Project0;
import java.sql.SQLException;

public abstract class Bank {
	int accountNumber;
	double accountBalance;
	
	public Bank(int acctNum) {
		this.accountNumber = acctNum;
	}
	
	abstract void withdraw(double transAmount) throws SQLException; // synchronized
	abstract void deposit (double transAmount) throws SQLException; // synchronized
	abstract void transfer
		(double transAmount, int destinationAccount) throws SQLException; // synchronized
	abstract double checkBalance() throws SQLException;
}

