package com.test.algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSort {

  private static final Logger log = Logger.getLogger(InsertionSort.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");

    int arr[] = {12, 34, 54, 2, 3};
    System.out.println("Unsroted array");
    printArray(arr);

    InsertionSort ob = new InsertionSort();
    ob.sort(arr);

    System.out.println("Unsroted array");
    printArray(arr);

    log.log(Level.INFO, "<<<");
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }
  /*Function to sort array using insertion sort*/
  void sort(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;
      // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their
      // current position
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }
}
