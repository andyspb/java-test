package com.gd;

import java.util.HashSet;

class PairSum {
  static void printpairs(int arr[], int sum)
  {
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int i = 0; i < arr.length; ++i)
    {
      int temp = sum - arr[i];
      // checking for condition
      if (hashSet.contains(temp)) {
        System.out.println(
            "Pair with given sum "
                + sum + " is (" + arr[i]
                + ", " + temp + ")");
      }
      hashSet.add(arr[i]);
    }
  }

  // Driver Code
  public static void main(String[] args)
  {
    int A[] = { 1, 4, 45, 6, 10, 8, 11, 5, 6, 5 };
    int n = 16;
    printpairs(A, n);
  }
}
