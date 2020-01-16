package com.hacker.hashmaps;

import java.util.Arrays;
import java.util.List;

public class CountTriplets {
  static long countTriplets(List<Long> arr, long r) {
    return 0l;
  }

  public static void main(String[] args) {
    Long[] arr1 = new Long[] {new Long(1), new Long(2), new Long(2), new Long(4)};
    long r1 = countTriplets(Arrays.asList(arr1), 2);
    System.out.println(r1);

    Long[] arr2 =
        new Long[] {new Long(1), new Long(3), new Long(9), new Long(9), new Long(27), new Long(81)};
    long r2 = countTriplets(Arrays.asList(arr1), 2);
    System.out.println(r2);
  }
}
