package com.javatest.algorithm;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Given a binary tree, print the nodes out grouping by level a / \ b d c
 *
 * a bd c
 */

class TreeNode {
  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public int size() {
    return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
  }

  public TreeNode left;
  public TreeNode right;
  public int data;
}

public class LevelOrder {

  // iterative method to do level order traversal line by line
  static void printLevelOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> que = new LinkedList<TreeNode>();
    que.add(root);

    while (true) {
      int nodeCount = que.size();
      if (nodeCount == 0) {
        break;
      }
      while (nodeCount > 0) {
        TreeNode node = que.peek();
        System.out.print(node.data + " ");
        que.remove();
        if (node.left != null) {
          que.add(node.left);
        }
        if (node.right != null) {
          que.add(node.right);
        }
        --nodeCount;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // Let us create binary tree shown in above diagram
    // 1
    // / \
    // 2 3
    // / \ \
    // 4 5 6

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    printLevelOrder(root);
  }
}
