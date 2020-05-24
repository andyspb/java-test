package com.test.util;

public class Utils {

  public static void log(String str) {
    System.out.println(str);
  }

  public static void printArray(int arr[]) {
    for (int a : arr) System.out.print(a + " ");
    System.out.println();
  }

  public static void swap(Integer a, Integer b) {
    System.out.println("a=" + a + " b=" + b);
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("a=" + a + " b=" + b);
  }

  public static void main(String[] args) {
    int a = 4;
    int b = 1124;

    System.out.println("a=" + a + " b=" + b);

    swap(a, b);

    System.out.println("a=" + a + " b=" + b);
  }
}
