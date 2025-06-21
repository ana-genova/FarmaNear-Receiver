package br.com.fiap.FarmaNear_Receiver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String login;
  private String password;

  public User() {
  }

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }
}
