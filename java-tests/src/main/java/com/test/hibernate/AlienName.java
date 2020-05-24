package com.test.hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** @author Andrey Krutogolov */
@Entity
@Table(name = "alien_name")
public class AlienName {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotNull
  private int id;

  private String name;
  private String surname;

  public AlienName() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surmame) {
    this.surname = surmame;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  private String phone;
  private String address;

  @Override
  public String toString() {
    return "AlienName{"
        + "name='"
        + name
        + '\''
        + ", surmame='"
        + surname
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", address='"
        + address
        + '\''
        + '}';
  }
}
