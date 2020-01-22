package com.test.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReverseStringArrayList {

  public static void main(String[] args) {

    String input = "Geeks For Geeks";
    System.out.println(input);

    char[] arr = input.toCharArray();
    List<Character> list = new ArrayList<>();

    for (char c : arr) {
      list.add(c);
    }

    Collections.reverse(list);
    Iterator<Character> iter = list.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next());
    }
    System.out.println();
  }
}
