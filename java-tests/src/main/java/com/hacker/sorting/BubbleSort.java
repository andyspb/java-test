package com.hacker.sorting;

public class BubbleSort {
  // Complete the countSwaps function below.
  static void countSwaps(int[] a) {
    if (a == null || a.length <= 1) return;
    int n = a.length;
    int countSwap = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          a[j] = a[j] ^ a[j + 1];
          a[j + 1] = a[j] ^ a[j + 1];
          a[j] = a[j] ^ a[j + 1];
          ++countSwap;
        }
      }
    }
    System.out.println("Array is sorted in " + countSwap + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n - 1]);
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3};
    countSwaps(arr);
  }
}
