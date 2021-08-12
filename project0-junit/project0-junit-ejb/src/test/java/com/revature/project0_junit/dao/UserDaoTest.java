package com.revature.project0_junit.dao;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.jboss.seam.annotations.In;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import com.revature.project0_junit.model.User;
import com.revature.project0_junit.testdata.UserTestdataBuilder;

public class UserDaoTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	@Rule
	public NeedleRule needleRule = new NeedleRule(databaseRule);

	@In
	private EntityManager entityManager;

	@ObjectUnderTest
	private UserDaoBean userDao;

	@Test
	public void testFindByUsername() throws Exception {

		User user = new UserTestdataBuilder(entityManager).buildAndSave();

		User findByUsername = userDao.findByUsername(user.getUsername());

		Assert.assertEquals(user.getId(), findByUsername.getId());

		User other = userDao.findByUsername("name");
		Assert.assertNull(other);
	}

}
