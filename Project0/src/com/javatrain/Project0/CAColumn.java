package com.javatrain.Project0;
import java.util.Date;

public class CAColumn {
	Date appDate;
    String fNom;
    String lNom;
    String phone;
    String address;
    int appNum;

    public CAColumn(Date appDt, String fN, String lN, String ph,
    		String addr, int appNo) {
        this.appDate = appDt;
        this.fNom = fN;
        this.lNom = lN;
        this.phone = ph;
        this.address = addr;
        this.appNum = appNo;
    }
    // ...
}
