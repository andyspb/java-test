package com.test.test;

import java.util.Arrays;

public class CharTest {
  public static void main(String[] args) throws Exception {
    char[] chars = new char[] {'\u0097'};
    String str = new String(chars);
    System.out.println(str);
    byte[] bytes = str.getBytes();
    System.out.println(Arrays.toString(bytes));
  }
}
