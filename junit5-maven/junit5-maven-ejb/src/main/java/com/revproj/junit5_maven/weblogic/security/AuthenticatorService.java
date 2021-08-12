package com.revproj.junit5_maven.weblogic.security;

import javax.ejb.Local;

@Local
public interface AuthenticatorService {
	String NAME = "authenticator";
	String JNDI_NAME = "java:app/junit5-maven-ejb/AuthenticatorServiceBean";

	boolean authenticate();
}
