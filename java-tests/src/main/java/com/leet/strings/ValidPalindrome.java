package com.leet.strings;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null) return false;
    if (s.length() <= 1) return true;

    s = s.toLowerCase();
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      while (i < j && !(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
        ++i;
      }
      while (i < j && !(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)))) {
        --j;
      }

      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      ++i;
      --j;
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "A man, a plan, a canal: Panama";
    String str2 = "race a car";
    ValidPalindrome vp = new ValidPalindrome();
    boolean b1 = vp.isPalindrome(str1);
    System.out.println(str1 + " - is palindrome: " + b1);
    boolean b2 = vp.isPalindrome(str2);
    System.out.println(str2 + " - is palindrome: " + b2);
  }
}
