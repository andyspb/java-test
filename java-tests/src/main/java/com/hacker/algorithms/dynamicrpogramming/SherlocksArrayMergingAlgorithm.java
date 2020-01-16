package com.hacker.algorithms.dynamicrpogramming;

public class SherlocksArrayMergingAlgorithm {
  private static long M = Long.MAX_VALUE;

  private static long bp(long a, long n) {
    long ret = 1;
    while (n > 0) {
      if (n % 2 == 1) ret *= a;
      ret %= M;
      a *= a;
      a %= M;
      n /= 2;
    }
    return ret;
  }

  static int arrayMerging(int[] m) {
    /*
     * Write your code here.
     */
    return 0;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1, 2, 3};
    int res = arrayMerging(arr);
    System.out.println(res);
  }
}
