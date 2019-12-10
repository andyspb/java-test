package com.algorithm;

//class BTNode<T> {
//
//  T value;
//  BTNode<?> left;
//  BTNode<?> rigth;
//
//  public BTNode<T>(T value)  {
//
//  }
//
//
//}


public class ReverseBinaryTreeRecursive {

  static void reverseTree(final TreeNode root) {
    if (root == null) {
      return;
    }

    final TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;

    reverseTree(root.left);
    reverseTree(root.right);
  }
}
