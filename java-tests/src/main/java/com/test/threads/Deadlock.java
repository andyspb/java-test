package com.test.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

// This class is shared by both threads
class Shared {
  synchronized void lock1(Shared shared) {
    System.out.println("lock1 >>>");
    shared.lock2(this);
    System.out.println("lock1 <<<");
  }

  synchronized void lock2(Shared shared) {
    System.out.println("lock2 >>>");
    shared.lock1(this);
    System.out.println("lock2 <<<");
  }
}

class Thread1 extends Thread {
  private Shared s1, s2;

  public Thread1(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  @Override
  public void run() {
    s1.lock1(s2);
  }
}

class Thread2 extends Thread {
  private Shared s1, s2;

  public Thread2(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  @Override
  public void run() {
    s2.lock2(s1);
  }
}

public class Deadlock {
  private static final Logger log = Logger.getLogger(Deadlock.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, "Deadlock >>>");

    Shared s1 = new Shared();
    Shared s2 = new Shared();

    Thread1 t1 = new Thread1(s1, s2);
    Thread2 t2 = new Thread2(s1, s2);

    t1.start();
    t2.start();

    try {
      Thread.currentThread().join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    log.log(Level.INFO, "<<<");
  }
}
