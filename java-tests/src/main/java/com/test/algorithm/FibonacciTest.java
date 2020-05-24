package com.test.algorithm;

public class FibonacciTest {

  // The method computes the Nth Fibonacci number.
  public static int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    System.out.println("Fibonacci test:");

    for (int n = 0; n <= 10; ++n) {
      int member = fib(n);
      System.out.println(" fib(" + n + "):" + member);
    }
  }
}
