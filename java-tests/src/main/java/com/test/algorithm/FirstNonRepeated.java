package com.test.algorithm;

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
    Character ch;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    final int len = str.length();
    for (int i = 0; i < len; ++i) {
      ch = str.charAt(i);
      map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
    }
    for (int i = 0; i < len; ++i) {
      ch = str.charAt(i);
      if (map.get(ch) == 1) {
        return ch;
      }
    }
    return null;
  }
}
