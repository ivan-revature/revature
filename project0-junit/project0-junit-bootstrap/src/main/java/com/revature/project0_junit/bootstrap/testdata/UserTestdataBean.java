package com.revature.project0_junit.bootstrap.testdata;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;

import com.revature.project0_junit.dao.UserDao;
import com.revature.project0_junit.model.User;

@Stateless
@Name(UserTestdata.NAME)
@JndiName(UserTestdata.JNDI_NAME)
public class UserTestdataBean implements UserTestdata {

	private static final String[][] DATA = { { "Fred", "Johnson" },
			{ "Donald", "McClure" }, { "Jerry", "Francis" } };
	private static final String PASSWORD = "secret";

	@EJB
	private UserDao userDao;

	@Override
	public void insert() {
		for (String[] data : DATA) {
			String firstname = data[0];
			String surname = data[1];
			String username = firstname.substring(0, 1) + surname;

			User user = new User();
			user.setFirstname(firstname);
			user.setSurname(surname);
			user.setUsername(username.toLowerCase());
			user.setPassword(PASSWORD);

			userDao.persist(user);
		}
	}

}
