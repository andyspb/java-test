package com.leet.array;

import java.util.Arrays;

public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    while (j < nums.length) {
      if (nums[j] != 0) {
        nums[i++] = nums[j];
      }
      j++;
    }
    while (i < nums.length) {
      nums[i++] = 0;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 12}; // -> [1,3,12,0,0]
    MoveZeroes mz = new MoveZeroes();
    mz.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
