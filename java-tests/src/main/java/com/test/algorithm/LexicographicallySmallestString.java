package com.test.algorithm;

import java.util.Stack;

public class LexicographicallySmallestString {
  // Lexicographically smallest string formed by removing at most one character.
  // Input: "abczd"
  // Output: "abcd"

  private static String getSmallString(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for(int i=0;i<s.length();i++) {
      char c  = s.charAt(i);
      if(!stack.isEmpty() && stack.peek() > c && count < 1) {
        stack.pop();
        count++;
      }
      stack.push(c);
    }
    if(count == 0)
      stack.pop();
    while(!stack.isEmpty()) {
      sb.insert(0,  stack.pop());
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    String s1 = "abczd";
    System.out.println(s1 + "->" + getSmallString(s1));
    String s2 = "abcde";
    System.out.println(s2 + "->" + getSmallString(s2));

  }
}
