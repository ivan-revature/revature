package com.revature.project0_junit.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface CommentTestdata {

	String NAME = "commentTestdata";
	String JNDI_NAME = "java:app/project0-junit-bootstrap/CommentTestdataBean";

	void insert();

}
