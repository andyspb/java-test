package com.leet;

// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

import java.util.*;

public class FindAllAnangramsInString {

  static final int MAX = 256;

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return result;
    }
    if (p.length() > s.length()) {
      return result;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    int match = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          match++;
        }
      }
      if (i >= p.length()) {
        c = s.charAt(i - p.length());
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
          if (map.get(c) == 1) {
            match--;
          }
        }
      }
      if (match == map.size()) {
        result.add(i - p.length() + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "abab";
    String p = "ab";

    FindAllAnangramsInString f = new FindAllAnangramsInString();

    List<Integer> res = f.findAnagrams(s, p);

    System.out.println(Arrays.toString(res.toArray()));
  }
}
