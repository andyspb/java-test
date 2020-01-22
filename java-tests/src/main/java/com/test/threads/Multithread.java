package com.test.threads;

import com.test.algorithm.FirstNonRepeated;

import java.util.logging.Level;
import java.util.logging.Logger;

class MultithreadThreadDemo extends Thread {
  private int localId;

  public MultithreadThreadDemo(int id) {
    localId = id;
  }

  @Override
  public void run() {
    try {
      System.out.println(
          "Thread " + Thread.currentThread().getId() + " is running, localId:" + localId);

    } catch (Exception e) {
      System.out.println("Exception is caught");
    }
  }
}

class MultithreadingRunnableDemo implements Runnable {
  private int localId;

  public MultithreadingRunnableDemo(int id) {
    localId = id;
  }

  @Override
  public void run() {
    try {
      // Displaying the thread that is running
      System.out.println(
          "Thread " + Thread.currentThread().getId() + " is running, localId:" + localId);

    } catch (Exception e) {
      // Throwing an exception
      System.out.println("Exception is caught");
    }
  }
}

// Main Class
public class Multithread {

  private static final Logger log = Logger.getLogger(FirstNonRepeated.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, "MultithreadThreadDemo >>>");

    int n = 8; // Number of threads
    for (int i = 0; i < n; ++i) {
      MultithreadThreadDemo object = new MultithreadThreadDemo(i);
      object.start();
      try {
        Thread.currentThread().join(10);
      } catch (Exception e) {
      }
    }

    log.log(Level.INFO, "MultithreadingRunnableDemo >>>");

    for (int i = 0; i < 8; ++i) {
      Thread object = new Thread(new MultithreadingRunnableDemo(i));
      object.start();
      try {
        Thread.currentThread().join(10);
      } catch (Exception e) {
      }
    }
  }
}
