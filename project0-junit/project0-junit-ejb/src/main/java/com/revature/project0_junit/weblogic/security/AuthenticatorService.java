package com.revature.project0_junit.weblogic.security;

import javax.ejb.Local;

@Local
public interface AuthenticatorService {
	String NAME = "authenticator";
	String JNDI_NAME = "java:app/project0-junit-ejb/AuthenticatorServiceBean";

	boolean authenticate();
}
