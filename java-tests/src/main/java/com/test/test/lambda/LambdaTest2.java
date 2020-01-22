package com.test.test.lambda;

public class LambdaTest2 {
  public static void main(String... args) {
    new Thread(() -> System.out.println("hello world")).start();
  }
}
