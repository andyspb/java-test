package com.test.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    stringList.add("Cat");
    stringList.add("Dog");
    stringList.add("CatDog");

    List<String> resultList =
        stringList.stream().filter(value -> value.startsWith("Cat")).collect(Collectors.toList());
    resultList.forEach(value -> System.out.println(value));
  }
}
