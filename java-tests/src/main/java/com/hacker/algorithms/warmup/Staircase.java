package com.hacker.algorithms.warmup;

public class Staircase {
  static void staircase(int n) {
    if (n <= 0) return;
    int counter = 0;
    for (int i = 0; i < n; ++i) {
      counter++;
      for (int k = n - 1; k > i; --k) System.out.print(" ");
      for (int j = 0; j <= counter - 1; ++j) System.out.print("#");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    staircase(4);
    System.out.println("=");
  }
}
