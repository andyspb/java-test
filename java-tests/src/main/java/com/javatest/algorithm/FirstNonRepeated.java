package com.javatest.algorithm;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstNonRepeated {

  private static final Logger log = Logger.getLogger(FirstNonRepeated.class.getName());

  public static void main(String[] args) {
    String str = "This is a test string";
    log.log(Level.INFO, "find first non-repeated character in :" + str);
    char c = firstNonRepeatedCharacter(str);
    log.info("c :" + c);
  }

  public static Character firstNonRepeatedCharacter(String str) {
    Character c;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    final int len = str.length();
    for (int i = 0; i < len; ++i) {
      c = str.charAt(i);
      map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
    }
    for (int i = 0; i < len; ++i) {
      c = str.charAt(i);
      if (map.get(c) == 1) {
        return c;
      }
    }
    return null;
  }
}
