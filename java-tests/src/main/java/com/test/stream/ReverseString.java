package com.test.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

  public static String Strrev(String str) {
    return Stream.of(str)
        .map(word -> new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    String str = "Hello, world!";

    System.out.println(Strrev(str));
    ;
  }
}
