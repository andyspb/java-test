package com.test.algorithm;

import java.util.Arrays;

public class StringSort {

  public static String sortString(String inputString) {
    char arr[] = inputString.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  public static void main(String[] args) {
    String s = "test";
    System.out.println(s);
    System.out.println(sortString(s));
  }
}
