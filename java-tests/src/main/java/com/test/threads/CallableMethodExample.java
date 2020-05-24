package com.test.threads;

import java.util.concurrent.*;

public class CallableMethodExample<V> implements Callable<V> {

  @Override
  public V call() throws Exception {
    for (int i = 1; i <= 3; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
      System.out.println(i);
    }
    return null;
  }

  public static void main(String args[]) {
    System.out.println(">> main");
    ExecutorService service = Executors.newSingleThreadExecutor();
    CallableMethodExample<Integer> callable = new CallableMethodExample<Integer>();
    Future<Integer> f = service.submit(callable);
    // try {
    // Integer result = callable.call();
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    try {
      f.get();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    service.shutdown();
    System.out.println("<< main");
  }
}
