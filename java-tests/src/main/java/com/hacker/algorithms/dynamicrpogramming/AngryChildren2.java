package com.hacker.algorithms.dynamicrpogramming;

import java.util.Arrays;

// python
//def angryChildren(k, packets):
//    packets.sort();
//    print(packets);
//    sum_ =0;
//    difference =0;
//    for i in range(k-1,-1,-1):
//    difference = difference + abs(packets[i]*(k-1 - i) - sum_);
//    sum_ = sum_ + packets[i];
//
//    min_diff = difference;
//    for i in range(k,len(packets)):
//    sum_ = sum_ - packets[i-k];
//    difference = difference - abs(sum_ - packets[i-k]*(k-1));
//    difference = difference + abs(sum_ - (k-1)*packets[i]);
//    if(difference < min_diff ):
//    min_diff = difference;
//
//    sum_ = sum_ + packets[i];
//
//    return min_diff;


public class AngryChildren2 {
  static long angryChildren(int k, int[] packets) {
    Arrays.sort(packets);
    System.out.println(Arrays.toString(packets));
    long sum = 0;
    long diff = 0;
    for (int i = k - 1; i > -1; --i) {
      diff = diff + Math.abs(packets[i] * (k - 1 - i) - sum);
      sum = sum + packets[i];
    }
    long min_diff = diff;
    for (int i = k; i < packets.length; ++i) {
      sum = sum - packets[i - k];
      diff = diff - Math.abs(sum - packets[i - k] * (k - 1));
      diff = diff + Math.abs(sum - (k - 1) * packets[i]);
      if (diff < min_diff) {
        min_diff = diff;
      }
      sum = sum + packets[i];
    }
    return min_diff;
  }

  public static void main(String[] args) {
    int k = 3; // children
    int[] arr = new int[] {10, 100, 300, 200, 1000, 20, 30};
    long res = angryChildren(3, arr);
    System.out.println(res);

    k = 4; // children
    arr = new int[] {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
    res = angryChildren(4, arr);
    System.out.println(res);
  }
}
