package concurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample {

  public static void main(String[] args) {

    MyCallable callable1 = new MyCallable(1000);
    MyCallable callable2 = new MyCallable(2000);

    FutureTask<String> ft1 = new FutureTask<String>(callable1);
    FutureTask<String> ft2 = new FutureTask<String>(callable2);

    ExecutorService executor = Executors.newFixedThreadPool(2);

    executor.execute(ft1);
    executor.execute(ft2);

    while (true) {
      try {
        if (ft1.isDone() && ft2.isDone()) {
          System.out.println("Done");
          executor.shutdown();
          return;
        }

        if (!ft1.isDone()) {
          System.out.println("ft1 result: " + ft1.get());
        }
        System.out.println("Waiting for ft2");
        String s = ft2.get(200L, TimeUnit.MICROSECONDS);
        if (s != null) {
          System.out.println("ft2 result: " + s);
        }
      } catch (TimeoutException e) {
        System.out.println("timeout exception");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
