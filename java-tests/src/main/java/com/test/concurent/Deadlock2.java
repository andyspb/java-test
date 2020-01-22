package com.test.concurent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Deadlock2 {
  private static final Logger log = Logger.getLogger(Deadlock2.class.getName());

  final Object lock1 = new Object();
  final Object lock2 = new Object();

  public static void main(String[] args) {
    log.log(Level.INFO, "Deadlock >>>");

    Deadlock2 d = new Deadlock2();

    Thread t1 =
        new Thread(
            new Runnable() {
              public void run() {
                d.method1();
              }
            });

    Thread t2 =
        new Thread(
            new Runnable() {
              public void run() {
                d.method2();
              }
            });

    t1.start();
    t2.start();

    log.log(Level.INFO, "<<<");
  }

  void method1() {
    synchronized (lock1) {
      synchronized (lock2) {
        System.out.println("from method1");
        try {
          Thread.currentThread().wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  void method2() {
    synchronized (lock2) {
      synchronized (lock1) {
        System.out.println("from method2");
        try {
          Thread.currentThread().wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }
}
