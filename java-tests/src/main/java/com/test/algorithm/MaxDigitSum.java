package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxDigitSum {
  private static int computeDigitSum(int a) {
    // supposed to be valid for negative numbers and the output must be non-negative integer.
    a = Math.abs(a);
    int res = 0;
    while (a > 0) {
      res += a % 10;
      a /= 10;
    }
    return res;
  }

  public static int maxSum(int[] A){
    int N = A.length;
    if(N <= 1) return -1;
    Map<Integer, Integer> map = new HashMap<>();
    int res = -1;
    for(int i = 0; i < N; ++i){
      int digitsum = computeDigitSum(A[i]);
      if(!map.containsKey(digitsum)){
        map.put(digitsum, A[i]);
      }
      else{
        res = Math.max(res, map.get(digitsum) + A[i]);
        map.put(digitsum, Math.max(A[i], map.get(digitsum)));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{51, 71, 17, 42};
    int res = maxSum(arr);
    System.out.println(res);

    arr = new int[]{51, 32, 43};
    res = maxSum(arr);
    System.out.println(res);
  }
}
