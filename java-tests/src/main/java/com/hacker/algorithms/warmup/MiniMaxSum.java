package com.hacker.algorithms.warmup;

public class MiniMaxSum {

  static void miniMaxSum(int[] arr) {
    long sum = 0, min = arr[0], max = arr[0];
    for (int i = 0; i < arr.length; ++i) {
      if (min > arr[i]) min = arr[i];
      if (max < arr[i]) max = arr[i];
      sum += arr[i];
    }
    System.out.println((sum - max) + " " + (sum - min));
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 5, 7, 9};
    miniMaxSum(arr);
  }
}
