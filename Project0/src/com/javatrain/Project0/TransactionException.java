package com.javatrain.Project0;

public class TransactionException extends Exception {
	String message;
	int transactionExceptionType;
	final int NEGATIVE_DEPOSIT_EXCEPTION = 1;
	final int INSUFFICIENT_FUNDS_EXCEPTION = 2;
	private static final long serialVersionUID = 1L;
	
	public TransactionException(int transExType) {
		this.transactionExceptionType = 
				transExType;
	}
	
	public String getMessage() {
		String msg = "";
		switch(transactionExceptionType) {
		case NEGATIVE_DEPOSIT_EXCEPTION:
			msg = "SYSTEM EXCEPTION 1: "
				+ "You attempted an invalid transaction. "
				+ "Deposit amounts can't be negative.";
			break;
		case INSUFFICIENT_FUNDS_EXCEPTION:
			msg = "SYSTEM EXCEPTION 2: "
					+ "You attempted an invalid transaction. "
					+ "There are insufficient funds in "
					+ "your account.";
			break;
		}
		return msg;
	}
}
