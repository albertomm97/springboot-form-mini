package com.springbootcourse.form.app.formtutorial.models;

import javax.validation.constraints.NotEmpty;

public class User {
  
  @NotEmpty
  private String username;
  
  @NotEmpty
  private String password;
  
  @NotEmpty
  private String email;

  public User() {

  }

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }
}
