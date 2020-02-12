package com.cat;

public class Test1{

  public static int findCharNumRec(String str, Character ch) {
    if (str == null || str.length() == 0)
      return 0;
    int res = 0;
    if (str.charAt(0) == ch)
      ++res;
    return res + findCharNumRec(str.substring(1),ch);
  }

  public static int findCharNumIter(String str, Character ch){
    if (str == null || str.length() == 0)
      return 0;
    int ret = 0;
    for (char c : str.toCharArray() ) {
      if (c==ch)
        ++ret;
    }
    return ret;
  }

  public static int findCharNumStream(String str, Character ch) {
    if (str == null || str.length() == 0) return 0;
    return (int) str.chars().filter(c -> c == ch).count();
  }


  public static void main(String[] args) {
    //
    String test = "HEllo, world!";
    System.out.println(findCharNumRec(test,'o'));
    System.out.println(findCharNumIter(test,'o'));
    System.out.println(findCharNumStream(test,'o'));
  }
}
