package com.gs;

public class SecondSmallest {
  /* Function to print first smallest and second smallest
  elements */
  static int print2Smallest(int x[]) {
    int first, second, arr_size = x.length;
    if (arr_size < 2) {
        /* There should be at least two elements */
      return 0;
    }

    first = second = Integer.MAX_VALUE;
    for (int i = 0; i < arr_size; i++) {
      if (x[i] <= first) {
        second = first;
        first = x[i];
      } else if (x[i] < second && x[i] != first) {
        second = x[i];
      }
    }
    if (second == Integer.MAX_VALUE) return first;
    else return second;
  }

  /* Driver program to test above functions */
  public static void main(String[] args) {
    // int arr[] = {12, 13, 1, 10, 34, 1};
    // int arr[] = {12, 13, 1, 10, 34, 1};
    //    int arr[] = {0, 1};
    int arr[] = {1, 0};
    int res = print2Smallest(arr);
    System.out.println(res);
  }
}
