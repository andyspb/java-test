package com.test.lambda;

public class FunctionalInterfaceTest {

  @FunctionalInterface
  interface Square {
    int calculate(int x);
  }

  public static void main(String[] args) {
    int a = 5;
    Square s = (int x) -> x * x;
    int res = s.calculate(a);

    System.out.println("s(" + a + ")= " + res);
  }
}
