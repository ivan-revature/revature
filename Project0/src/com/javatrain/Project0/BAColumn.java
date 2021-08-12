package com.javatrain.Project0;
//import java.util.Date;

public class BAColumn {
	int applicationNumber;
	String accountType;
	int customerNumber;
	double startingBalance;

    public BAColumn(int appNum,
    		String acctType,
    		int custNum,
    		double startBal) {
        this.applicationNumber = appNum;
        this.accountType = acctType;
        this.customerNumber = custNum;
        this.startingBalance = startBal;
    }
    // ...
}