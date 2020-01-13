package com.leet.trees;

public class MaxDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (null == root) return 0;

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return 1 + Math.max(leftDepth, rightDepth);
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(3);
    TreeNode tree1 = new TreeNode(9);
    TreeNode tree2 = new TreeNode(20);
    tree.left = tree1;
    tree.right = tree2;
    TreeNode tree4 = new TreeNode(15);
    TreeNode tree5 = new TreeNode(7);
    tree2.left = tree4;
    tree2.right = tree5;

    MaxDepthOfBinaryTree md = new MaxDepthOfBinaryTree();
    int depth = md.maxDepth(tree);

    System.out.println(depth);
  }
}
