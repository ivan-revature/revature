package com.revproj.junit5_maven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface BlogEntryTestdata {

	String NAME = "blogEntryTestdata";
	String JNDI_NAME = "java:app/junit5-maven-bootstrap/BlogEntryTestdataBean";

	void insert();

}
