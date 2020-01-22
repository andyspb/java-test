package com.test.test;

public class Practice {
  public static void main(String... args) {
    Boolean b = new Boolean("true");
    System.out.println(b);
    System.out.println("1");
  }

  public static void main(String args) {
    Boolean b = new Boolean("/false");
    System.out.println(b == false);
    System.out.println("2");
  }
}
