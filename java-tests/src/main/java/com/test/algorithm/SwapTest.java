package com.test.algorithm;

public class SwapTest {

  public static void main(String[] args) {
    System.out.println("Swap test >>>");

    int a = 4;
    int b = 1124;

    System.out.println("a=" + a + " b=" + b);

    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println("a=" + a + " b=" + b);

    a = a + b; // int owerflow may happens (( here
    b = a - b;
    a = a - b;

    System.out.println("a=" + a + " b=" + b);
  }
}
