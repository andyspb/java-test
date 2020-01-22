package com.test.concurent;

import java.util.concurrent.*;

public class ExecutorServiceTest {
  public static void main(String[] args) {

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Integer> future =
        executor.submit(
            () -> {
              String threadName = Thread.currentThread().getName();
              System.out.println("Hello " + threadName);
              return 1;
            });

    try {
      future.get(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TimeoutException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
