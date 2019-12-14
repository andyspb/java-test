package com.javatest.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

@SuppressWarnings(value = "deprecation")
public class ManageEmployee {
  private static SessionFactory factory;
  private static SessionFactory sessionFactory;
  private static ServiceRegistry serviceRegistry;

  private static SessionFactory configureSessionFactory() throws HibernateException {
    Configuration configuration = new Configuration();
    configuration.configure();
    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    sessionFactory = configuration.buildSessionFactory();
    return sessionFactory;
  }

  public static void main(String[] args) {
    try {
      factory = configureSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Failed to create sessionFactory object." + ex);
      throw new ExceptionInInitializerError(ex);
    }
    ManageEmployee ME = new ManageEmployee();

    /* Add few employee records in database */
    Integer empID1 = ME.addCustomer("Zara", "Ali", 1000);
    Integer empID2 = ME.addCustomer("Daisy", "Das", 5000);
    Integer empID3 = ME.addCustomer("John", "Paul", 10000);

    /* List down all the employees */
    ME.listCustomers();

    /* Update employee's records */
    ME.updateCustomer(empID1, "Test");

    /* Delete an employee from the database */
    ME.deleteEmployee(empID2);

    /* List down new list of the employees */
    ME.listCustomers();
  }

  /* Method to CREATE an employee in the database */
  private Integer addCustomer(String fname, String lname, int salary) {
    Session session = factory.openSession();
    Transaction transaction = null;
    Integer id = null;
    try {
      transaction = session.beginTransaction();
      Customer customer = new Customer(fname, lname);
      id = (Integer) session.save(customer);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
    return id;
  }

  /* Method to READ all the employees */
  private void listCustomers() {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      List customers = session.createQuery("FROM Customer").list();
      for (Object obj : customers) {
        Customer customer = (Customer) obj;
        System.out.print("First Name: " + customer.getFirstName());
        System.out.println("  Last Name: " + customer.getLastName());
      }
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to UPDATE salary for an employee */
  private void updateCustomer(Integer EmployeeID, String lastName) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Customer customer = (Customer) session.get(Customer.class, EmployeeID);
      customer.setLastName(lastName);
      session.update(customer);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to DELETE an employee from the records */
  private void deleteEmployee(Integer EmployeeID) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Customer employee = (Customer) session.get(Customer.class, EmployeeID);
      session.delete(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
}
