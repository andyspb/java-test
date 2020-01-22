package com.test.algorithm;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RadixSort {
  private static final Logger log = Logger.getLogger(RadixSort.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");

    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    print(arr);
    radixsort(arr, arr.length);
    print(arr);
  }

  static void radixsort(int arr[], int n) {
    int m = getMax(arr, n);
    for (int exp = 1; m / exp > 0; exp *= 10) {
      System.out.println("exp:" + exp);
      countSort(arr, n, exp);
      print(arr);
    }
  }

  static void countSort(int arr[], int n, int exp) {
    int output[] = new int[n]; // output array
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);

    // Store count of occurrences in count[]
    for (i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
    System.out.println("occurrences:");
    print(count);

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (i = 1; i < 10; i++) count[i] += count[i - 1];

    System.out.println("positions:");
    print(count);

    // Build the output array
    for (i = n - 1; i >= 0; --i) {
      System.out.println("arr[" + i + "]=" + arr[i]);
      System.out.println("(arr[" + i + "] / exp) % 10 -1)=" + (((arr[i] / exp) % 10) - 1));
      System.out.println(
          "count[(arr[" + i + "] / exp) % 10]-1]=" + (count[(arr[i] / exp) % 10] - 1));
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      System.out.println("count[(arr[" + i + "] / exp) % 10]=" + count[(arr[i] / exp) % 10]);
      --count[(arr[i] / exp) % 10];
    }

    // Copy the output array to arr[], so that arr[] now
    // contains sorted numbers according to current digit
    for (i = 0; i < n; ++i) arr[i] = output[i];
  }

  static int getMax(int arr[], int n) {
    int mx = arr[0];
    for (int i = 1; i < n; i++) if (arr[i] > mx) mx = arr[i];
    return mx;
  }

  static void print(int arr[]) {
    for (int a : arr) System.out.print(a + " ");
    System.out.println("");
  }
}
