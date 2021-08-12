package com.revproj.junit5_maven.weblogic;

import java.util.List;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.BlogEntry;

@Local
public interface BlogEntryListService {

	String NAME = "blogEntryListService";
	String JNDI_NAME = "java:app/junit5-maven-ejb/BlogEntryListServiceBean";

	List<BlogEntry> getResultList();

	int getNextFirstResult();

	int getPreviousFirstResult();

	Integer getFirstResult();

	void setFirstResult(Integer firstResult);

	boolean isPreviousExists();

	boolean isNextExists();

	void remove();

}
