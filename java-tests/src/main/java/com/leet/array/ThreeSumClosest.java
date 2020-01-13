package com.leet.array;

import java.util.Arrays;

/** @author Andrey Krutogolov */

// Given an array nums of n integers and an integer target, find three integers in nums such that
// the sum is closest to target. Return the sum of the three integers. You may assume that each
// input would have exactly one solution.

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int ret = 0;
    int temp = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(sum - target) < temp) {
          ret = sum;
          temp = Math.abs(sum - target);
        }
        if (sum > target) k--;
        else j++;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    ThreeSumClosest tsc = new ThreeSumClosest();
    int[] arr = new int[] {-1, 2, 1, -4};
    int res = tsc.threeSumClosest(arr, 1);
    System.out.println(res);
  }
}
