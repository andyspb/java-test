package com.test.language;

import java.util.concurrent.RecursiveAction;

public class Stream extends RecursiveAction {
  final int countProcessors = Runtime.getRuntime().availableProcessors();
  final int countLimit = 1000;
  int start;
  int end;
  int forSplit;

  Stream(int componentValue, int startNumber, int endNumber) {
    forSplit = componentValue;
    start = startNumber;
    end = endNumber;
  }

  @Override
  protected void compute() {
    Long countSum = 0L;
    if (countProcessors == 1 || end - start <= countLimit) {
      System.out.println("=run=");
      System.out.println("=start=" + start);
      System.out.println("=end=" + end);
      for (int i = start; i <= end; i++) {
        countSum += 1;
      }
    } else {
      int middle = (start + end) / 2;
      /*
       * invokeAll(new Stream(forSplit, start, middle), new Stream(forSplit, middle+1, end));
       */
      Stream goVar1 = new Stream(forSplit, start, middle);
      Stream goVar2 = new Stream(forSplit, middle, end);
      goVar1.fork();
      goVar2.fork();
      // countSum = goVar1.join() + goVar2.join();
    }
  }
}
