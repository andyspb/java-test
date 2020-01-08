package com.javatest.hibernate;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Andrey Krutogolov
 **/

@Entity
@Table(name = "alien_table")
public class Alien {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotNull
  private int aid;
  @OneToOne(cascade = {CascadeType.ALL})
  private AlienName name;
  private String color;

  public int getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }

  public AlienName getName() {
    return name;
  }

  public void setName(AlienName name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
