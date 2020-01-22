package com.test.bitwise;

public class Test {
  public static void main(String args[]) {
    int x = -4;
    System.out.println(x + " " + (x >> 1));
    int y = 4;
    System.out.println(y + " " + (y >> 1));

    int xx = -1;

    System.out.println(xx + " " + (xx >>> 29)); // The value of 'x>>>29' is 00...0111
    System.out.println(xx + " " + (xx >>> 30)); // The value of 'x>>>30' is 00...0011
    System.out.println(xx + " " + (xx >>> 31)); // The value of 'x>>>31' is 00...0
  }
}
