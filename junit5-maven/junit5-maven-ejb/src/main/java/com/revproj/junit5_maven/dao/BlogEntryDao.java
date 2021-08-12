package com.revproj.junit5_maven.dao;

import java.util.List;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.BlogEntry;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

	String NAME = "blogEntryDao";
	String JNDI_NAME = "java:app/junit5-maven-ejb/BlogEntryDaoBean";

	List<BlogEntry> find(int maxresults, int firstresult);

	Long count();

}
