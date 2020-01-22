package com.test.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
  public static void main(String... args) {
    System.out.println("StreamTest>>>>");

    List<String> list =
        Stream.of("AA", "AAA", "A").filter(s -> s.length() > 0).collect(Collectors.toList());

    list.forEach(s -> System.out.print(s + " "));

    System.out.println();

    IntStream.of(120, 410, 85, 32, 314, 12)
        .filter(x -> x < 300)
        .map(x -> x + 11)
        .limit(3)
        .forEach(s -> System.out.print(s + " "));
  }
}
