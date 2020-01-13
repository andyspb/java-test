package com.javatest.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/** @author Andrey Krutogolov */
public class App {
  public static void main(String[] args) {
    //
    AlienName name = new AlienName();
    name.setName("andy");
    name.setSurname("krut");
    name.setAddress("spb");
    name.setPhone("111-222-333");

    Alien telusko = new Alien();
    telusko.setAid(101);
    telusko.setName(name);
    telusko.setColor("green");

    Configuration cfg =
        new Configuration()
            .configure()
            .addAnnotatedClass(Alien.class)
            .addAnnotatedClass(AlienName.class);
    ServiceRegistry reg =
        new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

    SessionFactory sf = cfg.buildSessionFactory(reg);
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    session.save(telusko);
    tx.commit();
  }
}
