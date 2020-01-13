package com.leet.array;

public class RemoveDupsFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) return nums.length;
    int j = 0;
    int i = 1;

    while (i < nums.length) {
      if (nums[i] != nums[j]) {
        j++;
        nums[j] = nums[i];
      }

      i++;
    }
    return j + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    RemoveDupsFromSortedArray rdfs = new RemoveDupsFromSortedArray();
    int l = rdfs.removeDuplicates(nums);

    System.out.println(l);
  }
}
