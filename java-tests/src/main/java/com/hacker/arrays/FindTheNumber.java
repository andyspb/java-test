package com.hacker.arrays;

import java.util.Arrays;
import java.util.List;

public class FindTheNumber {
  public static String findNumber(List<Integer> arr, int k) {
    if (null == arr)
      return "NO";
    return arr.contains(k)?"YES":"NO";
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5});
    int elem = 1 ;
    String res = findNumber(list, elem);
    System.out.println(res);
  }
}
