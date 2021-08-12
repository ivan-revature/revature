package com.revature.project0_junit.weblogic;

import javax.ejb.Local;

import com.revature.project0_junit.model.Comment;

@Local
public interface CommentService {

	String NAME = "commentService";
	String JNDI_NAME = "java:app/project0-junit-ejb/CommentServiceBean";

	Comment getInstance();

	void save();

	void remove();

}
