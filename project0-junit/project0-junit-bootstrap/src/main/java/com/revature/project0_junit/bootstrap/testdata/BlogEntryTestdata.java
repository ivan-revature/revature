package com.revature.project0_junit.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface BlogEntryTestdata {

	String NAME = "blogEntryTestdata";
	String JNDI_NAME = "java:app/project0-junit-bootstrap/BlogEntryTestdataBean";

	void insert();

}
