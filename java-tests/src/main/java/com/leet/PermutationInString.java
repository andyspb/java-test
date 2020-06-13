package com.leet;

import java.util.Arrays;

public class PermutationInString {
  //  Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
  //  s1. In other words, one of the first string's permutations is the substring of the second
  // string.

  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s1.isEmpty()) {
      return false;
    }
    if (s2 == null || s2.isEmpty()) {
      return false;
    }
    if (s1.length() > s2.length()) {
      return false;
    }
    char arr[] = s1.toCharArray();
    Arrays.sort(arr);
    String s1Sorted = new String(arr);
    int s1len = s1.length();
    for (int i = 0; i < s2.length(); ++i) {
      if (i + s1len <= s2.length()) {
        String subStr = s2.substring(i, i + s1len);
        System.out.println(subStr);
        arr = subStr.toCharArray();
        Arrays.sort(arr);
        String subStr2sorted = new String(arr);
        if (s1Sorted.equals(subStr2sorted)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    PermutationInString pis = new PermutationInString();

    String s1 = "adc";
    String s2 = "dcda";

    boolean res = pis.checkInclusion(s1, s2);
    System.out.println(res);
  }
}
