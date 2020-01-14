package com.hacker.string;

public class AlternatingCharacters {
  static int alternatingCharacters(String s) {
    int res = 0;
    if (s == null || s.length()<=1)
      return res;
    for (int i = 0; i < s.length()-1; ++i) {
      if (s.charAt(i) == s.charAt(i + 1))
        ++res;
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "AABAAB";
    System.out.println(alternatingCharacters(s));
  }
}
