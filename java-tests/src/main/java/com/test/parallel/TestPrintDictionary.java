package com.test.parallel;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class TestPrintDictionary {

  static final String WORD_DELIMITERS_REGEX = "[ \\t,.?!:;\"()\\[\\]«»…]+";
  static final ArrayList<String> nonWords = new ArrayList<>(Arrays.asList("-", "–"));

  static void printDictionary(String name, Map<?, ?> c) {
    out.printf(c.isEmpty() ? "Dictionary '%s' is empty.\n" : "Dictionary '%s':\n", name);
    c.forEach((k, v) -> out.printf("\t%s[%s] == %d\n", name, k, v));
  }

  static void printDictionarySortedByValue(String name, Map<?, Integer> c) {
    out.printf(c.isEmpty() ? "Dictionary '%s' is empty.\n" : "Dictionary '%s':\n", name);
    c.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue() - e1.getValue())
        .forEach(e -> out.printf("\t%s[%s] == %d\n", name, e.getKey(), e.getValue()));
  }

  public static void main(String[] args) {
    try {
      // Map<String, Integer>
      printDictionarySortedByValue(
          "words",
          Files.lines(Paths.get("/home/andy/github/java-test/test/text.txt"))
              .flatMap(s -> Arrays.stream(s.split(WORD_DELIMITERS_REGEX)))
              .filter(s -> !s.isEmpty() && !nonWords.contains(s))
              .map(String::toLowerCase)
              .collect(Collectors.toMap(k -> k, k -> 1, (v1, v2) -> v1 + v2)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
