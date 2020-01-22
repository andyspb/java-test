package com.test.algorithm;

import java.util.logging.Logger;

public class ReverseString {
  private static final Logger log = Logger.getLogger(ReverseString.class.getName());

  public static void main(String[] args) {
    System.out.println("ReverseString >>>");

    String string = "Hello, World!";
    String rev = new StringBuilder(string).reverse().toString();
    System.out.println(string + '\n' + rev);
  }
}
