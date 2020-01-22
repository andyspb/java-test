package com.test.concurent;

import com.test.test.futures.FuturesTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReentrantLockTest2 {
  private static final Logger log = Logger.getLogger(FuturesTest.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, "From ReentrantLockTest()");

    ExecutorService executor = Executors.newFixedThreadPool(2);
    ReentrantLock lock = new ReentrantLock();

    executor.submit(
        () -> {
          lock.lock();
          try {
            Thread.sleep(1);
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } finally {
            lock.unlock();
          }
        });

    executor.submit(
        () -> {
          System.out.println("Locked: " + lock.isLocked());
          System.out.println("Held by me: " + lock.isHeldByCurrentThread());
          boolean locked = lock.tryLock();
          System.out.println("Lock acquired: " + locked);
        });
  }
}
