package com.hacker._30days;

public class Arrays {
  public static void main(String[] args) {
    //
    int arr[] = new int[] {1, 2, 3, 4};
    for (int i = arr.length - 1; i >= 0; --i) {
      System.out.print(arr[i]);
      if (i > 0) System.out.print(' ');
    }
  }
}
