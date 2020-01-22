package com.test.concurent;

public class MyRunnable implements Runnable {
  private final long countUtil;

  public MyRunnable(long countUtil) {
    this.countUtil = countUtil;
  }

  @Override
  public void run() {
    long sum = 0;
    for (long i = 1; i < countUtil; ++i) {
      sum += i;
    }
    System.out.println(sum);
  }
}
