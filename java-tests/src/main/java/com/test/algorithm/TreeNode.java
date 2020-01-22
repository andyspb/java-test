package com.test.algorithm;

class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int value;

  public TreeNode() {
  }

  public TreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int size() {
    return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
  }

}
