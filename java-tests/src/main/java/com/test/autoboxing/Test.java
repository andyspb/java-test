package com.test.autoboxing;

public class Test {
  public static void main(String args[]) {
    Integer x = 400, y = 400;
    if (x == y) System.out.println("Same");
    else System.out.println("Not Same");

    if (x.intValue() == y.intValue()) System.out.println("Value Same");
    else System.out.println("Value Not Same");

    Integer x1 = 40, y1 = 40;
    if (x1 == y1) System.out.println("Same");
    else System.out.println("Not Same");

    if (x1.intValue() == y1.intValue()) System.out.println("Value Same");
    else System.out.println("Value Not Same");
  }
}
