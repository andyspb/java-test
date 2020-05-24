package com.test.generic;

import java.util.ArrayList;
import java.util.List;

public class WildMaskTest {

  static void printList(List<?> list) {
    for (Object l : list) {
      System.out.print("{" + l + "} ");
    }

    System.out.println();
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(100);
    printList(list);
    List<String> strList = new ArrayList<String>();
    strList.add("10");
    strList.add("100");
    printList(strList);
  }
}
