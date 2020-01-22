package com.test.concurent;

import java.util.concurrent.CountDownLatch;

/** @author Andrey Krutogolov */
public class CountDownDriver2 {
  private static int N = 5;

  public static void main(String... args) throws InterruptedException {
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(N);

    for (int i = 0; i < N; ++i) // create and start threads
    new Thread(new Worker(startSignal, doneSignal)).start();

    System.out.println(" doSomethingElse();            // don't let run yet");
    startSignal.countDown(); // let all threads proceed
    System.out.println(" doSomethingElse();");
    doneSignal.await(); // wait for all to finish
  }
}

class Worker implements Runnable {
  private final CountDownLatch startSignal;
  private final CountDownLatch doneSignal;

  Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
    this.startSignal = startSignal;
    this.doneSignal = doneSignal;
  }

  public void run() {
    try {
      startSignal.await();
      doWork();
      doneSignal.countDown();
    } catch (InterruptedException ex) {
    } // return;
  }

  void doWork() {
    System.out.println("doWork >>>");
  }
}
