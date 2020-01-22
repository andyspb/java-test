package com.test.forkJoin;

public class Calc {
  public void go(int numberForCalc) {
    System.out.println("Calc go()");
    for (int i = 0; i <= numberForCalc; i++) {
      double pow = Math.pow(numberForCalc, 100);
    }
  }
}
