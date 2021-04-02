package com.test.algorithm;

public class FibonacciTest {

  // The method computes the Nth Fibonacci number.
  public static int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  public int fibonacciIterative(int n) {
    if(n <= 1) {
      return n;
    }
    int fib = 1;
    int prevFib = 1;

    for(int i=2; i<n; i++) {
      int temp = fib;
      fib+= prevFib;
      prevFib = temp;
    }
    return fib;
  }

  public static void main(String[] args) {
    System.out.println("Fibonacci test:");

    for (int n = 0; n <= 10; ++n) {
      int member = fib(n);
      System.out.println(" fib(" + n + "):" + member);
    }
  }
}
