package com.jurismali.jurismaliback.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
    /*
    * garantissent l'unicité d'une colonne ou d'un ensemble de colonnes.
    * */
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@Data
public class Utilisateurs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  @Size(max = 80)
  private String nomcomplet;

  @Size(max = 25)
  private String photo;

  @Size(max = 120)
  private String adresse;

  @NotBlank
  @Size(max = 120)
  private String genre;

  @NotBlank
  @Size(max = 120)
  private String numerotelephone;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "utilisateurs")
  List<Demande> mescreations=new ArrayList<>();

  /*@JsonIgnore
  @OneToMany(mappedBy = "demandeur")
  List<Demande> mesdemandes=new ArrayList<>();*/

  public Utilisateurs() {
  }

  public Utilisateurs(String username, String email, String password, String adresse,
   String nomcomplet, String photo)
  {
    this.username = username;
    this.email = email;
    this.password = password;
    this.adresse = adresse;
    this.nomcomplet = nomcomplet;
    this.photo = photo;
  }

  public Utilisateurs(String username, String email, String encode, String nomcomplet, String adresse, String numerotelephone, String genre) {
    this.username = username;
    this.email = email;
    this.password = encode;
    this.adresse = adresse;
    this.nomcomplet = nomcomplet;
    this.numerotelephone = numerotelephone;
    this.genre = genre;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

}
