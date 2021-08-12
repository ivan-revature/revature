package com.revproj.junit5_maven.weblogic.security;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.jboss.seam.security.Credentials;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.InjectIntoMany;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import de.akquinet.jbosscc.needle.mock.EasyMockProvider;
import com.revproj.junit5_maven.dao.UserDao;
import com.revproj.junit5_maven.testdata.UserTestdataBuilder;
import com.revproj.junit5_maven.weblogic.security.AuthenticatorServiceBean;

public class AuthenticatorServiceBeanTest {

	@Rule
	public NeedleRule needleRule = new NeedleRule();

	@ObjectUnderTest
	private AuthenticatorServiceBean authenticator;

	@EJB
	private UserDao userDaoMock;

	private EasyMockProvider mockProvider = needleRule.getMockProvider();

	@InjectIntoMany
	private Credentials credentials = new Credentials();

	@Test
	public void testLoginFailed() throws Exception {
		EasyMock.expect(
				userDaoMock.findByUsername(EasyMock.<String> anyObject()))
				.andReturn(null);

		mockProvider.replayAll();
		boolean login = authenticator.authenticate();
		Assert.assertFalse(login);

		mockProvider.verifyAll();
	}

	@Test
	public void testLoginWithWrongPassword() throws Exception {

		String username = "username";

		credentials.setUsername(username);
		credentials.setPassword("any");

		mockProvider.resetToStrict(userDaoMock);

		EasyMock.expect(userDaoMock.findByUsername(username)).andReturn(
				new UserTestdataBuilder().withUsername(username).build());

		mockProvider.replayAll();
		boolean login = authenticator.authenticate();
		Assert.assertFalse(login);
		mockProvider.verifyAll();

	}

	@Test
	public void testLoginSuccess() throws Exception {
		String username = "username";
		credentials.setUsername(username);
		credentials.setPassword("secret");

		mockProvider.resetToStrict(userDaoMock);
		EasyMock.expect(userDaoMock.findByUsername(username)).andReturn(
				new UserTestdataBuilder().withUsername(username).build());

		mockProvider.replayAll();
		boolean login = authenticator.authenticate();
		Assert.assertTrue(login);
		mockProvider.verifyAll();
	}

}
