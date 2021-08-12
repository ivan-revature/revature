package com.revature.project0_junit.weblogic;

import java.util.List;

import javax.ejb.Local;

import com.revature.project0_junit.model.BlogEntry;

@Local
public interface BlogEntryListService {

	String NAME = "blogEntryListService";
	String JNDI_NAME = "java:app/project0-junit-ejb/BlogEntryListServiceBean";

	List<BlogEntry> getResultList();

	int getNextFirstResult();

	int getPreviousFirstResult();

	Integer getFirstResult();

	void setFirstResult(Integer firstResult);

	boolean isPreviousExists();

	boolean isNextExists();

	void remove();

}
