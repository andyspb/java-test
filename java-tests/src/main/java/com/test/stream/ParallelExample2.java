package com.test.stream;

//
//  @author Andrey Krutogolov
//

import java.util.ArrayList;

public class ParallelExample2 {
  public static void main(String[] args) {

    System.out.println("Normal...");

    ArrayList<Integer> testValues = new ArrayList();
    testValues.add(0, 1);
    testValues.add(1, 2);
    testValues.add(2, 3);
    testValues.add(3, 4);
    testValues.add(4, 5);
    testValues.add(5, 6);
    testValues.add(6, 7);
    testValues.add(7, 8);
    testValues.add(8, 9);
    testValues.add(9, 10);

    testValues.stream().forEach(System.out::println);

    System.out.println("Parallel...");

    testValues.parallelStream().forEach(System.out::println);
  }
}
