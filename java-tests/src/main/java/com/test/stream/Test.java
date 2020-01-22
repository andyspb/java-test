package com.test.stream;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/** @author Andrey Krutogolov */
public class Test {
  //  static {
  //    final int SUM = IntStream.range(0, 100)
  //        .parallel()
  //        .reduce(new IntBinaryOperator() {
  //          @Override
  //          public int applyAsInt(int n, int m) {
  //            return sum(n, m);
  //          }
  //        })
  //        .getAsInt();
  ////    System.out.println("SUM:"+SUM);
  //  }

  private static int sum(int n, int m) {
    System.out.println(n + " " + m);
    return n + m;
  }

  public static void main(String[] args) {
    final int SUM =
        IntStream.range(0, 100)
            .parallel()
            .reduce(
                new IntBinaryOperator() {
                  @Override
                  public int applyAsInt(int n, int m) {
                    return sum(n, m);
                  }
                })
            .getAsInt();
    System.out.println("SUM:" + SUM);
    System.out.println("Finished");
  }
}
