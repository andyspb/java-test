package com.hacker.arrays;

import java.util.Arrays;

public class LeftRotation {
  static int[] rotLeft(int[] a, int d) {
    if(a == null )
      return a;
    int l = a.length;
    if (l<d)
      return a;
    d = d % l;
    int[] b = new int[l];
    for (int i = 0; i < l; ++i) {
      int j = ( i + l - d ) % l;
      b[j] = a[i];
    }
    return b;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    int key = 4;
    System.out.println(Arrays.toString(arr));
    int[] brr = rotLeft(arr,key);
    System.out.println(Arrays.toString(brr));
  }
}
