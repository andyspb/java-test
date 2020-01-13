package com.leet.array;
// Given a non-empty array of integers, every element appears twice except for one. Find that single
// one.
// Your algorithm should have a linear runtime complexity. Could you implement it without using
// extra memory?

public class SingleNumber {
  public int singleNumber(int[] nums) {
    if (nums.length < 1) return -1;
    if (nums.length == 1) return nums[0];

    int res = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      res = res ^ nums[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {4, 1, 2, 1, 2};
    SingleNumber sn = new SingleNumber();
    int single = sn.singleNumber(nums);
    System.out.println(single);
  }
}
