package test.hibernate;

import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import test.futures.FuturesTest;

import org.hibernate.SessionFactory;

public class ManageEmployee2 {
  private static SessionFactory factory;
  private static Random random = new Random();
  private static final Logger log = Logger.getLogger(ManageEmployee2.class.getName());


  public static void main(String[] args) {
    log.log(Level.INFO, ">>> ManageEmployee2.main()");
    try {
      factory = new Configuration().configure().
      // addPackage("com.xyz") //add package if used.
          addAnnotatedClass(Employee.class).buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Failed to create sessionFactory object." + ex);
      throw new ExceptionInInitializerError(ex);
    }
    ManageEmployee2 ME2 = new ManageEmployee2();

    ME2.deleteAllEmployees();

    /* Add few employee records in database */
    Integer empID1 = ME2.addEmployee("Zara", "Ali", randomSalary());
    Integer empID2 = ME2.addEmployee("Daisy", "Das", randomSalary());
    Integer empID3 = ME2.addEmployee("John", "Paul", randomSalary());

    /* List down all the employees */
    ME2.listEmployees();

    /* Update employee's records */
    ME2.updateEmployee(empID1, 5000);

    /* Delete an employee from the database */
    ME2.deleteEmployee(empID2);

    /* List down new list of the employees */
    ME2.listEmployees();
  }

  static private int randomSalary() {
    return random.nextInt(10000);
  }

  /* Method to CREATE an employee in the database */
  public Integer addEmployee(String fname, String lname, int salary) {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    try {
      tx = session.beginTransaction();
      Employee employee = new Employee();
      employee.setFirstName(fname);
      employee.setLastName(lname);
      employee.setSalary(salary);
      employeeID = (Integer) session.save(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
    return employeeID;
  }

  /* Method to READ all the employees */
  public void listEmployees() {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      List employees = session.createQuery("FROM Employee").list();
      for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
        Employee employee = (Employee) iterator.next();
        System.out.print("First Name: " + employee.getFirstName());
        System.out.print("  Last Name: " + employee.getLastName());
        System.out.println("  Salary: " + employee.getSalary());
      }
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to DELETE all the employees */
  public void deleteAllEmployees() {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      List employees = session.createQuery("FROM Employee").list();
      for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
        Employee employee = (Employee) iterator.next();
        session.delete(employee);
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
  public void updateEmployee(Integer EmployeeID, int salary) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Employee employee = (Employee) session.get(Employee.class, EmployeeID);
      employee.setSalary(salary);
      session.update(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to DELETE an employee from the records */
  public void deleteEmployee(Integer EmployeeID) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Employee employee = (Employee) session.get(Employee.class, EmployeeID);
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
