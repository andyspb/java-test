package com.test.algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SubstringsOfStringMain {

  private static final Logger log = Logger.getLogger(SubstringsOfStringMain.class.getName());

  public static void main(String args[]) {
    String str = "abbc";
    log.log(Level.INFO, ">>>");
    System.out.println("All substring of abbc are:");
    for (int i = 0; i < str.length(); ++i) {
      for (int j = i + 1; j <= str.length(); ++j) {
        System.out.println(str.substring(i, j));
      }
    }
  }
}
