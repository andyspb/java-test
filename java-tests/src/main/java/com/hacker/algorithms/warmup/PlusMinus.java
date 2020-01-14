package com.hacker.algorithms.warmup;

import java.text.DecimalFormat;

public class PlusMinus {
  static void plusMinus(int[] arr) {
    int counterPlus = 0;
    int counterMinus = 0;
    int counterZero = 0;
    DecimalFormat df = new DecimalFormat("0.000000");
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i] > 0) {
        ++counterPlus;
      } else if (arr[i] < 0) {
        ++counterMinus;
      } else {
        ++counterZero;
      }
    }
    System.out.println(df.format((double)counterPlus/arr.length));
    System.out.println(df.format((double)counterMinus/arr.length));
    System.out.println(df.format((double)counterZero/arr.length));
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 1, 0, -1, -1};
    plusMinus(arr);
    System.out.println();
    arr = new int[] {-4, 3, -9, 0, 4, 1};
    plusMinus(arr);
  }
}
