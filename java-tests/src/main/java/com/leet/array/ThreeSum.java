package com.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author Andrey Krutogolov */

//    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//    Find all unique triplets in the array which gives the sum of zero.
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // O(nlogn)
    for (int i = 0; i < nums.length; ++i) {
      int j = i + 1;
      int k = nums.length - 1;
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      while (j < k) {
        if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
          k--;
          continue;
        }

        if (nums[i] + nums[j] + nums[k] > 0) {
          k--;
        } else if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else {
          List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
          result.add(l);
          j++;
          k--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    ThreeSum ts = new ThreeSum();
    List res = ts.threeSum(nums);
    System.out.println(res);
  }
}
