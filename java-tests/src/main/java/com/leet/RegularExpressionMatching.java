package com.leet;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    if(p.length() == 0)
      return s.length() == 0;

    //p's length 1 is special case
    if(p.length() == 1 || p.charAt(1) != '*'){
      if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
        return false;
      return isMatch(s.substring(1), p.substring(1));

    }else{
      int len = s.length();

      int i = -1;
      while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
        if(isMatch(s.substring(i+1), p.substring(2)))
          return true;
        i++;
      }
      return false;
    }
  }

  public boolean isMatchIndex(String s, String p) {
    return helper(s, p, 0, 0);
  }


    public static void main(String[] args) {
    String s = "aa";
    String p = "a";
    RegularExpressionMatching rem = new RegularExpressionMatching();
    boolean res = rem.isMatch(s,p);
    System.out.println(res);
  }

  private boolean helper(String s, String p, int i, int j) {
    if (i >= s.length() && j >= p.length()) {
      return true;
    }


    if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
      if (helper(s, p, i, j + 2)) {
        return true;
      }

      if (p.charAt(j) == '.') {
        for (int k = i; k < s.length(); k++) {
          if (helper(s, p, k + 1, j + 2)) {
            return true;
          }
        }
      } else {
        for (int k = i; k < s.length(); k++) {
          if (s.charAt(k) == p.charAt(j)) {
            if (helper(s, p, k + 1, j + 2)) {
              return true;
            }
          } else {
            break;
          }
        }
      }
    } else if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
      return helper(s, p, i + 1, j + 1);
    }

    return false;
  }

}
