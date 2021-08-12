package com.revature.project0_junit.dao;

import java.util.List;

import javax.ejb.Local;

import com.revature.project0_junit.model.BlogEntry;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

	String NAME = "blogEntryDao";
	String JNDI_NAME = "java:app/project0-junit-ejb/BlogEntryDaoBean";

	List<BlogEntry> find(int maxresults, int firstresult);

	Long count();

}
