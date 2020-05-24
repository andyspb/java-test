package com.test.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

final class Test {
  private final String name;

  public Test(String name) { // private constructor
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public synchronized void bow(Test bower) {
    System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
    bower.bowBack(this);
  }

  public synchronized void bowBack(Test bower) {
    System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
  }
}

public class DeadlockTest {
  private static final Logger log = Logger.getLogger(Deadlock.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");

    // System.out.println("#0");
    // for (String s: args) {
    // System.out.print(s + " ");
    // }
    // System.out.println("#1");

    final Test alphonse = new Test("alphonse");
    final Test gaston = new Test("gaston");
    Thread t1 =
        new Thread(
            new Runnable() {
              // @Override
              @Override
              public void run() {
                alphonse.bow(gaston);
              }
            });

    Thread t2 =
        new Thread(
            new Runnable() {
              // @Override
              @Override
              public void run() {
                gaston.bow(alphonse);
              }
            });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    log.log(Level.INFO, ">>>");
  }
}
