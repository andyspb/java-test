package com.leet.strings;

import java.util.HashMap;

public class Anagram {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) return false;

    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      if (map.containsKey(c1)) {
        map.put(c1, map.get(c1) + 1);
      } else {
        map.put(c1, 1);
      }
    }
    for (int i = 0; i < s.length(); i++) {
      char c2 = t.charAt(i);
      if (map.containsKey(c2)) {
        if (map.get(c2) == 1) {
          map.remove(c2);
        } else {
          map.put(c2, map.get(c2) - 1);
        }
      } else {
        return false;
      }
    }
    return map.size() == 0;
  }

  public static void main(String[] args) {
    //
    String s = "anagram";
    String t = "nagaram";
    Anagram a = new Anagram();
    boolean res = a.isAnagram(s, t);
    System.out.println(res);
  }
}
