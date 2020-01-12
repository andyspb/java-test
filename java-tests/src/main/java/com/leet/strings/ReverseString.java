package com.leet.strings;

/** @author Andrey Krutogolov */
public class ReverseString {

  public void reverseString(char[] s) {
    if (s.length <= 1) {
      return;
    }
    reverse(s, 0, s.length - 1);
  }

  private void reverse(char[] s, int i, int j) {
    if (i < j) { // swap
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
      reverse(s, ++i, --j);
    }
  }

  public static void main(String[] args) {
    ReverseString rs = new ReverseString();
    char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
    System.out.println(s);
    rs.reverseString(s);
    System.out.println(s);
  }
}
