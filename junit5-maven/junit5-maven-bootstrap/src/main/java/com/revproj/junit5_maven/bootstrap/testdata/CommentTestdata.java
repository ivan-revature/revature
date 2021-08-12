package com.revproj.junit5_maven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface CommentTestdata {

	String NAME = "commentTestdata";
	String JNDI_NAME = "java:app/junit5-maven-bootstrap/CommentTestdataBean";

	void insert();

}
