package com.javatrain.Project0;
import java.util.Date;

public abstract class BankSystem {
	// package-private instance variables
	String bankName;
	long transactionID;
	Date transactionDate = new Date();
	long accountNumber;
	int transactionType;
	boolean transactionIsValid;
	
	public BankSystem(String bnkName, long transID,
			long acctNumber, int transType, boolean transIsValid) {
		this.bankName = bnkName;
		this.transactionID = transID;
		this.accountNumber = acctNumber;
		this.transactionType = transType;
		this.transactionIsValid = transIsValid;
	}
	
	public void setTransactionIsValid(boolean transIsValid) {
		this.transactionIsValid = transIsValid;
	}
	
	public boolean getTransactionIsValid() {
		return this.transactionIsValid;
	}
	
	
}
