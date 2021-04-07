package com.gd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum4 {

  // Approach 1: Brute Force
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] { i, j };
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  // Approach 2: Two-pass Hash Table
  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  // Approach 3: One-pass Hash Table

  public int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    int[] nums = new int[] {2, 7, 11, 15};
    int target = 22;
    System.out.println(Arrays.toString(nums));
    System.out.println("target: " + target);
    TwoSum4 ts = new TwoSum4();
    System.out.println(
        "TwoSum for target: " + target + " : " + Arrays.toString(ts.twoSum(nums, target)));
    System.out.println(
        "TwoSum for target: " + target + " : " + Arrays.toString(ts.twoSum2(nums, target)));
    System.out.println(
        "TwoSum for target: " + target + " : " + Arrays.toString(ts.twoSum3(nums, target)));
  }

}
