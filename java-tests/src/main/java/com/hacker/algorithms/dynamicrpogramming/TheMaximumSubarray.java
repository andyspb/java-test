package com.hacker.algorithms.dynamicrpogramming;

import java.util.Arrays;

public class TheMaximumSubarray {

  static int[] maxSubarray(int[] arr) {
    int maxEndingHere = arr[0];
    int maxSoFar = arr[0];
    int maxSequence = arr[0];

    for(int i=1;i<arr.length;i++){
      maxEndingHere = Math.max(arr[i],arr[i]+maxEndingHere);
      maxSequence = Math.max(Math.max(maxSequence,arr[i]+maxSequence),arr[i]);
      maxSoFar = Math.max(maxSoFar,maxEndingHere);
    }

    return new int[] {maxSoFar, maxSequence};
  }

  public static void main(String[] args) {
    int[] arr = new int[] {2,-1,2,3,4,-5};
    System.out.println(Arrays.toString(arr));
    int[] res = maxSubarray(arr);
    System.out.println(Arrays.toString(res));
  }
}
