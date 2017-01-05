package org.gooru.nucleus.reports.api.gateway.responses.auth;

public interface AuthResponseHolder {

  boolean isAuthorized();

  boolean isAnonymous();
  
  String getUserId();
}
