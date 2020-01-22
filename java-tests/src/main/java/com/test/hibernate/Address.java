package com.test.hibernate;

import javax.persistence.OneToOne;

/** @author Andrey Krutogolov */

// @Entity
// @Table(name="alien_address")
public class Address {
  @OneToOne private int alienId;
}
