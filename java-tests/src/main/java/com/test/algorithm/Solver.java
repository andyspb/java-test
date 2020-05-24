package com.test.algorithm;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class Solver extends RecursiveAction {
  private int[] arr;
  private long result;

  public Solver(int[] array) {
    this.arr = array;
  }

  public long getResult() {
    return this.result;
  }

  @Override
  protected void compute() {
    if (arr.length == 1) {
      result = arr[0];
    } else {
      int midpoint = arr.length / 2;
      int[] l1 = Arrays.copyOfRange(arr, 0, midpoint);
      int[] l2 = Arrays.copyOfRange(arr, midpoint, arr.length);
      Solver s1 = new Solver(l1);
      Solver s2 = new Solver(l2);
      forkJoin(s1, s2);

      result = s1.result + s2.result;
    }
  }

  private void forkJoin(RecursiveAction r1, RecursiveAction r2) {
    r1.fork();
    r2.fork();
    r1.join();
    r2.join();
  }
}
