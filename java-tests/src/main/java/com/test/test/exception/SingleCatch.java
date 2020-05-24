package com.test.test.exception;

import java.util.Scanner;

public class SingleCatch {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    try {
      int n = Integer.parseInt(scanner.nextLine());
      if (99 % n == 0) System.out.println(n + " is a factor of 99");
    } catch (NumberFormatException | ArithmeticException ex) {
      System.out.println("Exception encountered " + ex);
    } finally {
      scanner.close();
    }
  }
}
