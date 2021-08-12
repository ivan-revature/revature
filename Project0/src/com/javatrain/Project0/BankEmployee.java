package com.javatrain.Project0;

public abstract class BankEmployee {
	boolean approveAccountApplication;
	// accountData[];
	
	public abstract String[] viewAccountData(long acctNumber);
	public abstract boolean approveAccount(long acctNumber);
	public abstract String[] viewTransactionLog(long custNumber);
}
