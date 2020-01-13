package com.leet.dynamic;

public class HouseRobber {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int l = nums.length;
    int[] dp = new int[l];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < l; ++i) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[l - 1];
  }

  public static void main(String[] args) {
    HouseRobber hr = new HouseRobber();
    int[] nums = new int[] {2, 7, 9, 3, 1};
    int res = hr.rob(nums);
    System.out.println(res);
  }
}
