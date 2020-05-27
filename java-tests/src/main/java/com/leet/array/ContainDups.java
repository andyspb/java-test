package com.leet.array;

// Given an array of integers, find if the array contains any duplicates.
import java.util.HashSet;
import java.util.Set;

public class ContainDups {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ContainDups cd = new ContainDups();
    int[] nums = new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    boolean containDups = cd.containsDuplicate(nums);
    System.out.println("ContainDups:" + containDups);
  }
}
