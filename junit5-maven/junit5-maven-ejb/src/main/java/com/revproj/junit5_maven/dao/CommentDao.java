package com.revproj.junit5_maven.dao;

import java.util.List;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.BlogEntry;
import com.revproj.junit5_maven.model.Comment;

@Local
public interface CommentDao extends Dao<Comment> {

	String NAME = "commentDao";
	String JNDI_NAME = "java:app/junit5-maven-ejb/CommentDaoBean";

	List<Comment> findComments(BlogEntry blogEntry);

}
