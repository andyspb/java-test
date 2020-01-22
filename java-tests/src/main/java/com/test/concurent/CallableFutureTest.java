package com.test.concurent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    Random random = new Random();
    Integer randomInteger = random.nextInt(5);

    Thread.sleep(randomInteger * 1000);
    return randomInteger;
  }
}

public class CallableFutureTest {

  public static void main(String... args) throws Exception {
    FutureTask[] randomNumberTasks = new FutureTask[5];
    for (int i = 0; i < 5; i++) {
      Callable callable = new CallableExample();
      randomNumberTasks[i] = new FutureTask(callable);

      Thread t = new Thread(randomNumberTasks[i]);
      t.start();
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(randomNumberTasks[i].get());
    }
  }
}
