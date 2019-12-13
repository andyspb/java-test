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
    Customer emp = new Customer();
    emp.setFirstName("demo");
    emp.setLastName("user");

    session.save(emp);

    session.getTransaction().commit();
    HibernateUtil.shutdown();
  }
}
