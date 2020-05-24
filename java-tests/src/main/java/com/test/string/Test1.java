package com.test.string;

public class Test1 {
  static {
    System.out.println("Left");
    // System.exit(0);
  }

  public static void main(Object... args) {
    System.out.print("Objects");
  }

  public static void main(java.lang.String[] args) {
    System.out.println("Middle");
  }

  class String {}

  public static void main(String... args) {
    System.out.println("Right");
  }
}
