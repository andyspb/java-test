package com.test.java8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortUsingJava8 {
  private static void sortUsingJava8(List<String> names) {
    Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
  }

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();
    list.add("one");
    list.add("two");
    list.add("three");

    System.out.println(list);
    sortUsingJava8(list);
    list.forEach(System.out::println);
  }
}
