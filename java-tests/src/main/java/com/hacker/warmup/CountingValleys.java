package com.hacker.warmup;

public class CountingValleys {
  static int countingValleys(int n, String s) {
    int sum = 0;
    int count = 0;
    for(char c : s.toCharArray()){
      if(c == 'U') {
        if (++sum == 0)
          count++;
      } else
        sum--;
    }
    return count;
  }

  public static void main(String[] args) {
    String s = "UDDDUDUU";
    int v =- countingValleys(s.length(), s);
    System.out.println(v);
  }
}
