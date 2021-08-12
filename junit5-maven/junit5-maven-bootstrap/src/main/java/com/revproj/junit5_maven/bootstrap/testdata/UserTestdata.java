package com.revproj.junit5_maven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface UserTestdata {

	String NAME = "userTestdata";
	String JNDI_NAME = "java:app/junit5-maven-bootstrap/UserTestdataBean";

	void insert();
}
