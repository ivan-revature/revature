package com.revature.project0_junit.bootstrap;

import javax.ejb.Local;

@Local
public interface ApplicationBootstrap {
  String NAME = "applicationBootstrap";
  String JNDI_NAME = "java:app/project0-junit-bootstrap/ApplicationBootstrapBean";

  void init();
}