package com.test.array;

import java.util.Arrays;
import java.util.logging.Logger;

public class CompareArrays {

  private static final Logger log = Logger.getLogger(CompareArrays.class.getName());

  public static void main(String[] args) {
    log.info("Test compare arrays");
    int arr1[] = {1, 2, 3};
    int arr2[] = {1, 2, 3};
    log.info("Compare objects:");
    if (arr1 == arr2) // Same as arr1.equals(arr2)
    System.out.println("Same");
    else System.out.println("Not same");

    log.info("Compare with Arrays.equals:");
    if (Arrays.equals(arr1, arr2)) System.out.println("Same");
    else System.out.println("Not same");
  }
}
