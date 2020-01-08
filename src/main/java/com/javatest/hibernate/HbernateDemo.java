package com.javatest.hibernate;

import org.hibernate.Session;

/**
 * @author Andrey Krutogolov
 */
public class HbernateDemo {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    // Add new Employee object
    Customer customer = new Customer();
    customer.setFirstName("demo");
    customer.setLastName("user");

    session.save(customer);

    session.getTransaction().commit();
    HibernateUtil.shutdown();
  }
}
