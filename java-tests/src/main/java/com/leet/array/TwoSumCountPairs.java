package com.leet.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumCountPairs {
  public int twoSum(int[] nums, int sum) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, 0);
      }
      map.put(num, map.get(num) + 1);
    }
    int count = 0;
    for (int num : nums) {
      int diff = sum - num;
      if (map.get(diff) != null) {
        count += map.get(diff);
      }
      if (diff == num) {
        --count;
      }
    }
    return count / 2;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 0, 1}; // target 2 1 -> [0,2]
    //    int[] nums = new int[] {1, 1, 1}; // target 2 3 -> [0,1] [0,2] [1,2]
    //    int[] nums = new int[] {1, 2, 3, -1, -2, 0 }; //target 3  2 -> [1,2] [3,0]
    TwoSumCountPairs ts = new TwoSumCountPairs();
    System.out.println(Arrays.toString(nums));
    System.out.println("target_sum_count: " + ts.twoSum(nums, 2));
  }
}
