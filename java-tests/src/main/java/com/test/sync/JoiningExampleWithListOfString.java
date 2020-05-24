package com.test.sync;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExampleWithListOfString {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
    String result = list.stream().collect(Collectors.joining());
    System.out.println(result);
    result = list.stream().collect(Collectors.joining(","));
    System.out.println(result);
    result = list.stream().collect(Collectors.joining("-", "[", "]"));
    System.out.println(result);
  }
}
