package com.jurismali.jurismaliback.payload.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Set;

@Data
public class SignupRequest {

  @Size(min = 3, max = 20)
  private String username;

  @Size(min = 3, max = 50)
  @Email
  private String email;

  @Size(min = 3, max = 80)
  private String nomcomplet;

  @Size(min = 3, max = 120)
  private String adresse;

  @Size(min = 8, max = 8)
  private String numerotelephone;

  @Size(min = 8, max = 8)
  private String genre;




  private Set<String> role;

  @Size(min = 6, max = 40)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
