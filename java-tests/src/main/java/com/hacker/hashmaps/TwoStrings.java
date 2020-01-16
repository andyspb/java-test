package com.hacker.hashmaps;

public class TwoStrings {
  static String twoStrings(String s1, String s2) {
    if (s1 == null || s2 == null )
      return "NO";
    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
       if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
         return "YES";
       }
    }
    return "NO";
  }

  public static void main(String[] args) {
    String s1="hello";
    String s2="world"; // YES
    twoStrings(s1,s2);

    String s11 = "hi";
    String s22 = "world"; // no
    twoStrings(s11,s22);
  }
}
