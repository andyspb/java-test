package com.gd;

import java.util.Arrays;

// Move zeros to end of the array like 1023 to 1230
public class MoveZerosToEndOfArray {

  static void pushZerosToEnd(int arr[], int n)
  {
    int count = 0;  // Count of non-zero elements

    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[count++] = arr[i];      }
    }
    while (count < n) {
      arr[count++] = 0;
    }
  }

  public static void main (String[] args)
  {
    int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
    System.out.println(Arrays.toString(arr));

    int n = arr.length;
    pushZerosToEnd(arr, n);

    System.out.println("Array after pushing zeros to the back: ");
    System.out.println(Arrays.toString(arr));
  }
}
