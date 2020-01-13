package com.javatest.hibernate;

import javax.persistence.*;

/** @author Andrey Krutogolov */
@Entity
@Table(name = "order")
public class Order {
  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private int orderId;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  @Column(name = "amount")
  private int amount;

  @Column(name = "customer_id")
  private int customerId;

  public Order() {}

  public Order(int orderId, int amount, int customerId) {
    this.orderId = orderId;
    this.amount = amount;
    this.customerId = customerId;
  }
}
