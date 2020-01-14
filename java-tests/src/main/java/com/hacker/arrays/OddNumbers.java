package com.hacker.arrays;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {
  public static List<Integer> oddNumbers(int l, int r) {
    // Write your code here
    List<Integer> list = new ArrayList<>();
    if (l > r) return list;
    for (int i = l; i <= r; ++i) {
      if (i % 2 != 0) {
        list.add(i);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    List res = oddNumbers(2, 5);
    System.out.println(res);
    res = oddNumbers(3, 9);
    System.out.println(res);
  }
}
