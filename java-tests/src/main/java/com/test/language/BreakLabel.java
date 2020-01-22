package com.test.language;

public class BreakLabel {
  public static void main(String[] argv) {
    lab1:
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j >= 5 && i > 5) break lab1;
        System.out.println(i + " / " + j);
      }
    }
  }
}
