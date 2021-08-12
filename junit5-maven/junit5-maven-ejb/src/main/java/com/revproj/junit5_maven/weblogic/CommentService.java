package com.revproj.junit5_maven.weblogic;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.Comment;

@Local
public interface CommentService {

	String NAME = "commentService";
	String JNDI_NAME = "java:app/junit5-maven-ejb/CommentServiceBean";

	Comment getInstance();

	void save();

	void remove();

}
