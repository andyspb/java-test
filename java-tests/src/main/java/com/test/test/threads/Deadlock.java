package com.test.test.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Deadlock {
  private static final Logger log = Logger.getLogger(Deadlock.class.getName());

  public static Object o1 = new Object();
  public static Object o2 = new Object();

  private static volatile int v1 = 0;
  private static volatile int v2 = 0;

  public static void main(String[] args) {
    Thread t1 =
        new Thread() {
          public void run() {
            synchronized (o1) {
              log.log(Level.INFO, "t1 sync(o1) >");
              v1 = 1;
              while (v2 != 1) ;
              synchronized (o2) {
                log.log(Level.INFO, "t1 sync(o2) >");
              }
            }
          }
        };
    Thread t2 =
        new Thread() {
          public void run() {
            synchronized (o2) {
              log.log(Level.INFO, "t2 sync(o1) >");
              v2 = 1;
              while (v1 != 1) ;
              synchronized (o1) {
                log.log(Level.INFO, "t2 sync(o1) >");
              }
            }
          }
        };

    t1.start();
    t2.start();
  }
}
