package com.leet.dynamic;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int result = nums[0];
    int sum = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      sum = Math.max(nums[i], sum + nums[i]);
      result = Math.max(result, sum);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6 4,-1,2,1
    MaximumSubarray ms = new MaximumSubarray();
    int max = ms.maxSubArray(nums);
    System.out.println(max);
  }
}
