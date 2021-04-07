package com.gd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Find the duplicated elements from array ( result list cannot contain duplicated elements )
public class FindDuplicatesInArray {

  public static Set<Integer> findDups1(int[] array) {
    Set<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < array.length; i++) {
      if (set.add(array[i]) == false) {
        System.out.println("Duplicate element found : " + array[i]);
      }
    }
    return set;
  }

  public static void main(String[] args) {
    int[] array = {1, 1, 2, 3, 4, 5, 6, 7, 8, 8};
    System.out.println(Arrays.toString(array));
    Set<Integer> set = findDups1(array);
    System.out.println(Arrays.toString(set.toArray()));
  }
}
