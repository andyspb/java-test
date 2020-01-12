package com.leet.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumAllUniqPairs {
  public int twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;

    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[i] + nums[j]) == target) count++;
      }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1}; // 3 -> [0,1] [0,2] [1,2]
    int target = 2;
    TwoSumAllUniqPairs ts = new TwoSumAllUniqPairs();
    System.out.println(Arrays.toString(nums));
    System.out.println("twice_count: " + ts.twoSum(nums, target));
  }
}
