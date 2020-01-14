package com.hacker.algorithms.warmup;

public class BirthdayCakeCandles {
  static int birthdayCakeCandles(int[] ar) {
    int tall = 0;
    int freq = 0;
    for (int i = 0; i < ar.length; i++) {
      if (ar[i] > tall) {
        tall = ar[i];
        freq = 1;
      } else if (ar[i] == tall) freq++;
    }
    return freq;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 2, 1, 3};
    System.out.println(birthdayCakeCandles(arr));
  }
}
