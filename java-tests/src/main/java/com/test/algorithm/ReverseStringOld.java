package com.test.algorithm;

public class ReverseStringOld {
  public static void main(String[] args) {
    String inputStr = "GeeksforGeeks";

    System.out.println(inputStr);

    char[] arr = inputStr.toCharArray();

    int len = arr.length;

    for (int i = 0; i < len >> 1; ++i) {
      char temp = arr[i];
      arr[i] = arr[len - i - 1];
      arr[len - i - 1] = temp;
    }

    System.out.println(new String(arr));
  }
}
