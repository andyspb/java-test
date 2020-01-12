package com.leet.array;

import java.util.Arrays;
import java.util.HashMap;

/** @author Andrey Krutogolov */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) return new int[] {0, 0};
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; ++i) {
      int t = target - nums[i];
      System.out.println(" " + i + " num[" + i + "]:" + nums[i] + "  (target - nums[i]):" + t);
      if (map.containsKey(nums[i])) {
        System.out.println("Found key: " + nums[i]);
        return new int[] {map.get(nums[i]), i};
      } else {
        System.out.println("put key:" + t + " value:" + i);
        map.put(target - nums[i], i);
      }
    }
    return new int[] {0, 0};
  }

  public static void main(String[] args) {
    int[] nums = new int[] {2, 7, 11, 15};
    int target = 22;
    TwoSum ts = new TwoSum();
    System.out.println(Arrays.toString(nums));
    System.out.println("TwoSum: " + Arrays.toString(ts.twoSum(nums, target)));
  }
}
