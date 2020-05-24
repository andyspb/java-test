package com.test.algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/** @author Andrey Krutogolov */
public class NumOfWords {
  public static void main(String[] args) {
    //
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);

    Path path = Paths.get("words.txt"); // путь к файлу
    Map<String, Integer> frequencyMap = new HashMap<>();

    try (Stream<String> lines = Files.lines(path)) {
      frequencyMap =
          lines
              .filter(item -> !item.isEmpty())
              .flatMap(line -> Arrays.stream(line.split("\\s+")))
              .collect(toMap(identity(), s -> 1, Integer::sum));
    } catch (IOException ignored) {
    }
    frequencyMap.entrySet().forEach(System.out::println);
  }
}
