package com.test.language;

import java.util.ArrayList;
import java.util.Optional;

public class StreamTest_FindMaxMin {
  public static void main(String... args) {
    ArrayList<Integer> testValues = new ArrayList<Integer>();
    testValues.add(0, 15);
    testValues.add(1, 1);
    testValues.add(2, 2);
    testValues.add(3, 100);
    testValues.add(4, 50);

    Optional<Integer> maxValue = testValues.stream().max(Integer::compareTo);
    System.out.println("MaxValue=" + maxValue);
    Optional<Integer> minValue = testValues.stream().min(Integer::compareTo);
    System.out.println("MinValue=" + minValue);

    ArrayList<Integer> testValuesNull = new ArrayList<Integer>();
    testValuesNull.add(0, null);
    testValuesNull.add(1, 1);
    testValuesNull.add(2, 2);
    testValuesNull.add(3, 70);
    testValuesNull.add(4, 50);
    Optional<Integer> maxValueNotNull =
        testValuesNull.stream().filter((p) -> p != null).max(Integer::compareTo);
    System.out.println("maxValueNotNull=" + maxValueNotNull);
  }
}
