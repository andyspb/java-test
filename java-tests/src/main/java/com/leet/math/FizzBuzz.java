package com.leet.math;

// Write a program that outputs the string representation of numbers from 1 to n.
// But for multiples of three it should output “Fizz” instead of the number and for the multiples
// of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>(n);
    if (n <= 0) {
      return list;
    }
    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        list.add("FizzBuzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else {
        list.add(String.valueOf(i));
      }
    }
    return list;
  }

  public static void main(String[] args) {
    FizzBuzz fb = new FizzBuzz();
    int n = 15;
    List<String> list = fb.fizzBuzz(n);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
