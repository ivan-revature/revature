package com.revproj.junit5_maven.dao;

import javax.ejb.Local;

import com.revproj.junit5_maven.model.User;

@Local
public interface UserDao extends Dao<User> {

	String NAME = "userDao";
	String JNDI_NAME = "java:app/junit5-maven-ejb/UserDaoBean";

	User findByUsername(String username);

}
