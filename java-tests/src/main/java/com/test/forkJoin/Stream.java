package com.test.forkJoin;

import java.util.concurrent.RecursiveAction;

public class Stream extends RecursiveAction {
  final int countProcessors = Runtime.getRuntime().availableProcessors();
  final int countLimit = 500000;
  int start;
  int end;
  int forSplit;

  public Stream(int componentValue, int startNumber, int endNumber) {
    System.out.println("Stream Stream()");
    forSplit = componentValue;
    start = startNumber;
    end = endNumber;
  }

  @Override
  protected void compute() {
    System.out.println("Stream compute() countProcessors=" + countProcessors);
    if (countProcessors == 1 || end - start <= countLimit) {
      System.out.println("=run=");
      for (int i = start; i <= end; i++) {
        new Calc().go(i);
      }
    } else {
      int middle = (start + end) / 2;
      invokeAll(new Stream(forSplit, 0, middle), new Stream(forSplit, middle + 1, end));
    }
  }
}
