package com.hacker.sorting;

import java.util.Arrays;

public class MarkAndToys {
  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int i = 0;
    while (k > 0) k -= prices[i++];
    return i - 1;
  }

  public static void main(String[] args) {
    int pricedToys = 7;
    int amount = 50;
    int[] arr = new int[] {1, 12, 5, 111, 200, 1000, 10}; // -> 4: 1,12,5,10
    System.out.println(maximumToys(arr, amount));
  }
}
