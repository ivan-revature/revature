package com.javatrain.Project0;
import java.sql.SQLException;

public class BankTransaction extends Bank {

	public BankTransaction(int custNum) {
		super(custNum);
	}
	
	synchronized void withdraw(double transAmount) 
		throws SQLException {
		BankTransaction bank = new BankTransaction(accountNumber);
		DBActions dbActions = new DBActions();
		double curBalance;
        System.out.println("withdraw processing...");
        curBalance = bank.checkBalance();
        if(curBalance < transAmount){
            System.out.println("balance insufficient, waiting for deposit..");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
        	curBalance-= transAmount;
        	if( dbActions.postNewBalance(
        			accountNumber, curBalance) ) {
        		System.out.println("withdraw completed!");
        		notify();
        	} else {
        		System.out.println("withdraw failed!");
        	}
        }
    }
	
	synchronized void deposit(double transAmount)
		throws SQLException {
		BankTransaction bank = new BankTransaction(accountNumber);
		DBActions dbActions = new DBActions();
		double newBalance;
        System.out.println("deposit processing...");
        newBalance = bank.checkBalance();
        newBalance += transAmount;
        if( dbActions.postNewBalance(accountNumber, newBalance) ) {
        	System.out.println("deposit completed!");
        	notify();
        } else {
        	System.out.println("deposit failed!");
        }
    }
	
	public void transfer(double transAmount, 
			int destinationAccount) throws
		SQLException {
		// post transfer to transactionsPending table
		DBActions dbActions = new DBActions();
		System.out.println("transfer processing...");
        if( dbActions.postTransfer(accountNumber, transAmount,
        		destinationAccount) ) {
        	System.out.println("transfer completed!");
        	//notify();
        } else
        	System.out.println("transaction failed.");
	}
	
	public double checkBalance() 
		throws SQLException {
		DBActions dbActions = new DBActions();
		return dbActions.getAccountBalance(accountNumber);
	}
}

class DepositThread extends Thread {
    Bank bank;
    int accountNum;
    double transAmt;
    
    public DepositThread(Bank bank, int acctNum, double amt) {
        this.bank = bank;
        this.accountNum = acctNum;
        this.transAmt = amt;
    }

    @Override
    public void run() {
	    try {
	    	if( this.transAmt < 0 )
	    		throw new TransactionException(1);
	    	else
	    		bank.deposit(this.transAmt);
	    } catch(Exception e) {
	    	System.out.println("Error caught in run: "
	    			+ e.getMessage());
	    }
    }
}

class WithdrawThread extends Thread {
    Bank bank;
    int accountNum;
    double transAmt;
    
    public WithdrawThread(Bank bank, int acctNum, double amt){
        this.bank = bank;
        this.accountNum = acctNum;
        this.transAmt = amt;
    }

    @Override
    public void run() {
	    try {
	    	bank.withdraw(this.transAmt);
	    } catch(Exception e) {
	    	System.out.println("Error caught in run: "
	    			+ e.getMessage());
	    }
    }
}

class TransferThread extends Thread {
	Bank bank;
	int accountNum;
	int destinationAcct;
	double transAmt;
	
	public TransferThread(Bank bank, int acctNum,
			double amt, int destNum) {
		this.bank = bank;
		this.accountNum = acctNum;
		this.transAmt = amt;
		this.destinationAcct = destNum;
	}
	
	@Override
	public void run() {
	    try {
	    	bank.transfer(this.transAmt,
	    			this.destinationAcct);
	    } catch(Exception e) {
	    	System.out.println("Error caught in run: "
	    			+ e.getMessage());
	    }
	}
}