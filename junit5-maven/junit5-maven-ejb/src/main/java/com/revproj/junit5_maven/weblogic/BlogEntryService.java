package com.revproj.junit5_maven.weblogic;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.BlogEntry;

@Local
public interface BlogEntryService {

	String NAME = "blogEntryService";
	String JNDI_NAME = "java:app/junit5-maven-ejb/BlogEntryServiceBean";

	BlogEntry getInstance();

	boolean newInstance();

	boolean persistOrUpdate();

	boolean delete();

	Long getId();

	void setId(Long id);

	void remove();
}
