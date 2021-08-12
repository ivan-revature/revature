package com.revproj.junit5_maven.bootstrap;

import javax.ejb.Local;

@Local
public interface ApplicationBootstrap {
  String NAME = "applicationBootstrap";
  String JNDI_NAME = "java:app/junit5-maven-bootstrap/ApplicationBootstrapBean";

  void init();
}