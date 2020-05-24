package com.leet.trees;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int x) {
    val = x;
    left = null;
    right = null;
  }

  TreeNode(int x, TreeNode l, TreeNode r) {
    val = x;
    left = l;
    right = r;
  }
}
