package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicatesInString {

  public static void main(String... args) {

    String str = "test";
    System.out.println("str: " + str);

    char[] arr = str.toCharArray();

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (Character ch : arr) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      Character key = entry.getKey();
      Integer num = entry.getValue();
      if (num == 2) {
        System.out.println(key);
      }
    }
  }
}
