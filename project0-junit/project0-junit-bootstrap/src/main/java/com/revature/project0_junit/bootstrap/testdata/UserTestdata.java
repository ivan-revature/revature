package com.revature.project0_junit.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface UserTestdata {

	String NAME = "userTestdata";
	String JNDI_NAME = "java:app/project0-junit-bootstrap/UserTestdataBean";

	void insert();
}
