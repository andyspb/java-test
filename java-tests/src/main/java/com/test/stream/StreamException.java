package com.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @author Andrey Krutogolov */
public class StreamException {

  private static Integer divide(Integer value, Integer factor) {
    try {
      return value / factor;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.getMessage();
    }
    return null;
  }

  public static List<Integer> scale(List<Integer> values, Integer factor) {
    return values.stream().map(n -> divide(n, factor)).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(10);
    list.add(20);
    list.add(null);

    System.out.println(list.toString());

    List<Integer> devidedList = scale(list, 2);

    System.out.println(devidedList.toString());
  }
}
