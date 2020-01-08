package com.leet.trees;

public class ConvertSortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] num, int start, int end) {
    if (start > end) return null;

    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(num[mid]);
    root.left = sortedArrayToBST(num, start, mid - 1);
    root.right = sortedArrayToBST(num, mid + 1, end);

    return root;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-10, -3, 0, 5, 9};
    ConvertSortedArrayToBST csab = new ConvertSortedArrayToBST();
    TreeNode node = csab.sortedArrayToBST(nums);
  }
}
