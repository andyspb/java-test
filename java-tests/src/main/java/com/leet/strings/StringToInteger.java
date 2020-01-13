package com.leet.strings;

public class StringToInteger {
  public int myAtoi(String str) {
    if (str == null) return 0;
    // trim white spa ces
    str = str.trim();
    if (str.length() < 1) return 0;
    char flg = '+';
    // check negative
    int i = 0;
    if (str.charAt(0) == '-') {
      flg = '-';
      i++;
    } else if (str.charAt(0) == '+') {
      i++;
    }
    // use doudle to store result
    double result = 0;
    while (str.length() > i && Character.isDigit(str.charAt(i))) {
      result = result * 10 + (str.charAt(i) - '0');
      ++i;
    }
    if (flg == '-') result = -result;
    if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    return (int) result;
  }

  public static void main(String[] args) {
    StringToInteger sti = new StringToInteger();
    System.out.println(sti.myAtoi("42"));
    System.out.println(sti.myAtoi("-42"));
    System.out.println(sti.myAtoi("4193 test"));
    System.out.println(sti.myAtoi("test 4193"));
    System.out.println(sti.myAtoi("-91283472332"));
  }
}
