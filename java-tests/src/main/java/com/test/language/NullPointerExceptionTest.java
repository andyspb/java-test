package com.test.language;

public class NullPointerExceptionTest {

  public static void main(String[] args) {
    try {
      doSomething();
    } catch (NullPointerException e) {
      System.out.print("Caught the NullPointerException");
    }
  }

  public static void doSomething() {
    String nullString = null;
    nullString.endsWith("test");
  }
}
