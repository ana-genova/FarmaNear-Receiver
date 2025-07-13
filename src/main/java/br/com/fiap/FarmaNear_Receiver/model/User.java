package br.com.fiap.FarmaNear_Receiver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String login;
  private String name;
  private String password;
  private String role;

  public User() {
  }

  public User(String login, String name, String password, RoleEnum role) {
    this.login = login;
    this.name = name;
    this.password = password;
    this.role = role.name();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public RoleEnum getRole() {
    return RoleEnum.valueOf(role);
  }
}
