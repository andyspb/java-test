package com.leet.others;

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
//    find the one that is missing from the array.
public class MissingNumber {
  public int missingNumber(int[] nums) {
    int all = (nums.length) * (nums.length + 1) / 2;
    for (int num : nums) all -= num;
    return all;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1};
    //    int[] nums = new int[] {3,0, 1};
    MissingNumber mn = new MissingNumber();
    int missing = mn.missingNumber(nums);
    System.out.println(missing);
  }
}
