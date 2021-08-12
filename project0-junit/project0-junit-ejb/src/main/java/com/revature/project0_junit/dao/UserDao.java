package com.revature.project0_junit.dao;

import javax.ejb.Local;

import com.revature.project0_junit.model.User;

@Local
public interface UserDao extends Dao<User> {

	String NAME = "userDao";
	String JNDI_NAME = "java:app/project0-junit-ejb/UserDaoBean";

	User findByUsername(String username);

}
