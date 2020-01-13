package com.leet.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    if (s == null) return false;
    if (s.length() == 0) return true;
    Map<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    if (s.length() == 1
        && (map.keySet().contains(s.charAt(0)) || map.values().contains(s.charAt(0)))) return false;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      char cur = s.charAt(i);
      if (map.keySet().contains(cur)) {
        stack.push(cur);
      } else if (map.values().contains(cur)) {
        if (!stack.empty() && map.get(stack.peek()) == cur) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    ValidParentheses vp = new ValidParentheses();
    String str = "()[]{}";
    boolean valid = vp.isValid(str);
    System.out.println(valid);
    str = "([)]";
    valid = vp.isValid(str);
    System.out.println(valid);
    str = "([{(())}])";
    valid = vp.isValid(str);
    System.out.println(valid);
  }
}
