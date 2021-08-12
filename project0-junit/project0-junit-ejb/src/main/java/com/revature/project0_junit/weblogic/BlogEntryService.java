package com.revature.project0_junit.weblogic;

import javax.ejb.Local;

import com.revature.project0_junit.model.BlogEntry;

@Local
public interface BlogEntryService {

	String NAME = "blogEntryService";
	String JNDI_NAME = "java:app/project0-junit-ejb/BlogEntryServiceBean";

	BlogEntry getInstance();

	boolean newInstance();

	boolean persistOrUpdate();

	boolean delete();

	Long getId();

	void setId(Long id);

	void remove();
}
