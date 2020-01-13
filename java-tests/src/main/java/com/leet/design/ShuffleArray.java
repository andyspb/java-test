package com.leet.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
  int[] original = null;
  int[] shuffle = null;
  Random rand = null;

  public ShuffleArray(int[] nums) {
    original = nums;
    shuffle = Arrays.copyOf(nums, nums.length);
    rand = new Random();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    shuffle = Arrays.copyOf(original, original.length);
    return shuffle;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    for (int i = 0; i < shuffle.length; i++) {
      int x = rand.nextInt(shuffle.length - i);
      int idx = x + i;

      int tmp = shuffle[idx];
      shuffle[idx] = shuffle[i];
      shuffle[i] = tmp;
    }
    return shuffle;
  }

  public static void main(String[] args) {
    //
    int[] nums = new int[] {1, 2, 3};
    ShuffleArray obj = new ShuffleArray(nums);
    int[] param_1 = obj.reset();
    int[] param_2 = obj.shuffle();
  }
}
