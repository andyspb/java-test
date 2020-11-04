package com.test.algorithm;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Anagram {

  public abstract void test();

  private static final Logger log = Logger.getLogger(Anagram.class.getName());

  public static boolean isAnagram(String firstWord, String secondWord) {
    char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
    char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
    Arrays.sort(word1);
    Arrays.sort(word2);
    return Arrays.equals(word1, word2);
  }

  public static void main(String[] args) {
    log.log(Level.INFO, "Anagram::main() >>>");

    String s1 = "aabb";
    String s2 = "abab";
    String s3 = "bbaa";

    log.log(
        Level.INFO, "Is anagrams(" + s1 + ", " + s2 + ") :" + Boolean.toString(isAnagram(s1, s2)));
    log.log(
        Level.INFO, "Is anagrams(" + s1 + ", " + s3 + ") :" + Boolean.toString(isAnagram(s1, s3)));
  }
}
