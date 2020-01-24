package com.hacker.warmup;

import java.util.Arrays;

public class SockMerchant {
  static int sockMerchant(int n, int[] ar) {
    Arrays.sort(ar);
    int socks = 0;
    for (int i = 1; i < n; ++i) {
      if (ar[i] == ar[i-1]) {
        ++socks;
        ++i;
      }
    }
    return socks;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {10,20,20,10,10,30,50,10,20};
    int n = arr.length;
    int socks = sockMerchant(n, arr);
    System.out.println("socks:" + socks);
  }
}
