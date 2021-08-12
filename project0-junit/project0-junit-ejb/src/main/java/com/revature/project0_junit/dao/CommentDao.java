package com.revature.project0_junit.dao;

import java.util.List;

import javax.ejb.Local;

import com.revature.project0_junit.model.BlogEntry;
import com.revature.project0_junit.model.Comment;

@Local
public interface CommentDao extends Dao<Comment> {

	String NAME = "commentDao";
	String JNDI_NAME = "java:app/project0-junit-ejb/CommentDaoBean";

	List<Comment> findComments(BlogEntry blogEntry);

}
