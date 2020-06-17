package com.leet;

public class ImplementStrStrKmp {
  // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
  // haystack.
  // What should we return when needle is an empty string? This is a great question to ask during an
  // interview.
  // For the purpose of this problem, we will return 0 when needle is an empty string

  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) return 0;

    int h = haystack.length();
    int n = needle.length();

    if (n > h) return -1;
    if (n == 0) return 0;


    int[] next = getNext(needle);

    int i = 0;

    while (i <= h - n) {
      int success = 1;
      for (int j = 0; j < n; j++) {
        if (needle.charAt(0) != haystack.charAt(i)) {
          success = 0;
          i++;
          break;
        } else if (needle.charAt(j) != haystack.charAt(i + j)) {
          success = 0;
          i = i + j - next[j - 1];
          break;
        }
      }
      if (success == 1) return i;
    }

    return -1;
  }

  // calculate KMP array
  public int[] getNext(String needle) {
    int[] next = new int[needle.length()];
    next[0] = 0;

    for (int i = 1; i < needle.length(); i++) {
      int index = next[i - 1];
      while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
        index = next[index - 1];
      }

      if (needle.charAt(index) == needle.charAt(i)) {
        next[i] = next[i - 1] + 1;
      } else {
        next[i] = 0;
      }
    }

    return next;
  }

  public static void main(String[] args) {
    //    String haystack = "hello";
    //    String needle = "ll";

    String haystack = "ababcaababcaabc";
    String needle = "ababcaabc";

    ImplementStrStrKmp iss = new ImplementStrStrKmp();
    int res = iss.strStr(haystack, needle);
    System.out.println(res);
  }
}
