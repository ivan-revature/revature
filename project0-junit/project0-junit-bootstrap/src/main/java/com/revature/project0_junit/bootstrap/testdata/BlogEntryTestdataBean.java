package com.revature.project0_junit.bootstrap.testdata;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;

import com.revature.project0_junit.dao.BlogEntryDao;
import com.revature.project0_junit.dao.UserDao;
import com.revature.project0_junit.model.BlogEntry;
import com.revature.project0_junit.model.User;

@Stateless
@Name(BlogEntryTestdata.NAME)
@JndiName(BlogEntryTestdata.JNDI_NAME)
public class BlogEntryTestdataBean implements BlogEntryTestdata {

	private static final String CONTENT = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet";
	private static final String TITLE = "Lorem ipsum dolor sit amet";

	private static final int QUANTITY = 5;

	@EJB
	private BlogEntryDao blogEntryDao;

	@EJB
	private UserDao userDao;

	@Override
	public void insert() {
		List<User> users = userDao.findAll();

		for (User user : users) {
			for (int i = 0; i < QUANTITY; i++) {
				BlogEntry blogEntry = new BlogEntry();
				blogEntry.setAuthor(user);
				blogEntry.setTitle(TITLE);
				blogEntry.setContent(CONTENT);

				blogEntryDao.persist(blogEntry);
			}
		}
	}
}
