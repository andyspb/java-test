package com.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Given two arrays, write a function to compute their intersection.
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
public class Intersection2Arrays {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i : nums2) {
      if (map.containsKey(i)) {
        if (map.get(i) > 1) {
          map.put(i, map.get(i) - 1);
        } else {
          map.remove(i);
        }
        list.add(i);
      }
    }
    return list.stream().mapToInt(Number::intValue).toArray();
  }

  public static void main(String[] args) {
    //        int[] nums1 = new int[]{4,9,5};
    //        int[] nums2 = new int[]{9,4,9,8,4};
    int[] nums1 = new int[] {1, 2, 2, 1};
    int[] nums2 = new int[] {2, 2};
    Intersection2Arrays i2a = new Intersection2Arrays();
    int[] intersection = i2a.intersect(nums1, nums2);
    System.out.println(Arrays.toString(intersection));
  }
}
