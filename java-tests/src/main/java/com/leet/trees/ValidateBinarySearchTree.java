package com.leet.trees;

public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode node) {
    return isValidBST(node, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  public boolean isValidBST(TreeNode node, double min, double max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = new TreeNode(4);
    root.left = node2;
    root.right = node3;
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(6);
    node3.left = node4;
    node3.right = node5;

    ValidateBinarySearchTree vbs = new ValidateBinarySearchTree();
    boolean valid = vbs.isValidBST(root);
    System.out.println(valid);
  }
}
