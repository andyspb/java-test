package com.hacker.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashTablesRansomNote {

  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> magOccurs = new HashMap<String, Integer>();
    Map<String, Integer> notOccurs = new HashMap<String, Integer>();
    for (String w : magazine) {
      if (!magOccurs.containsKey(w)) magOccurs.put(w, 0);
      magOccurs.put(w, magOccurs.get(w) + 1);
    }
    for (String w : note) {
      if (!notOccurs.containsKey(w)) notOccurs.put(w, 0);
      notOccurs.put(w, notOccurs.get(w) + 1);
    }

    for (String key : notOccurs.keySet()) {
      if (!magOccurs.containsKey(key)) {
        System.out.println("No");
        return;
      }
      int needed = notOccurs.get(key);
      if (magOccurs.get(key) < needed) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

  public static void main(String[] args) {
    String[] magazine = new String[] {"give", "me", "one", "grand", "today", "night"};
    String[] note = new String[] {"give", "one", "grand", "today"}; // -> Y
    checkMagazine(magazine, note);
    String[] magazine1 = new String[] {"two", "times", "three", "is not", "four"};
    String[] note2 = new String[] {"two", "times", "two", "is", "four"}; // -> N
    checkMagazine(magazine1, note2);
  }
}
