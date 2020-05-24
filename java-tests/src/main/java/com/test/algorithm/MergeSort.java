package com.test.algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort {
  private static final Logger log = Logger.getLogger(MergeSort.class.getName());

  private int[] arr;
  private int[] temp;
  private int len;

  public static void main(String[] args) {
    log.log(Level.INFO, "From MergeSort >>> ");
    int[] arr = {23, 12, 11, 0, 7, 3, 2};

    printArray(arr);
    new MergeSort().sort(arr);
    printArray(arr);
  }

  public void sort(int[] values) {
    this.arr = values;
    len = values.length;
    this.temp = new int[len];
    mergeSort(0, len - 1);
  }

  private void mergeSort(int low, int high) {
    // check if low is smaller than high, if not then the array is sorted
    if (low < high) {
      int piv = low + ((high - low) >> 1);
      mergeSort(low, piv);
      mergeSort(piv + 1, high);
      merge(low, piv, high);
    }
  }

  private void merge(int low, int mid, int high) {
    for (int i = low; i <= high; i++) {
      temp[i] = arr[i];
    }

    int i = low, k = low, j = mid + 1;
    while (i <= mid && j <= high) {
      if (temp[i] <= temp[j]) {
        arr[k] = temp[i];
        ++i;
      } else {
        arr[k] = temp[j];
        ++j;
      }
      ++k;
    }
    while (i <= mid) {
      arr[k] = temp[i];
      ++k;
      ++i;
    }
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }
}
