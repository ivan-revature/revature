package com.javatrain.Project0;

public abstract class BankCustomer {
	long customerNumber;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	
	public abstract boolean initiateDeposit(long acctNumber, double amt);
	public abstract boolean initiateWithdrawal(long acctNumber, double amt);
	public abstract double queryAccount(long acctNumber);
	public abstract boolean initiateTransfer(long acctNumber, double amt);
	public abstract boolean acceptTransfer();
}
