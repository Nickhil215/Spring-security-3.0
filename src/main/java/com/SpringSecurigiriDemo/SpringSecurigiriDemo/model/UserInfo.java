package com.SpringSecurigiriDemo.SpringSecurigiriDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends User{

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(unique = true)
  private String username;
  private String password;
  private String roles;

}
