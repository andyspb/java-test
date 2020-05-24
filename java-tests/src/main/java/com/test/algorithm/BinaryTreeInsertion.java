package com.test.algorithm;

import java.util.LinkedList;
import java.util.Queue;

class BTNode {
  public BTNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int size() {
    return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
  }

  public BTNode left;
  public BTNode right;
  public int value;
}

public class BinaryTreeInsertion {

  static BTNode root;
  static BTNode temp = root;

  static void inorder(BTNode temp) {
    if (temp == null) return;

    inorder(temp.left);
    System.out.print(temp.value + " ");
    inorder(temp.right);
  }

  static void insert(BTNode temp, int key) {
    Queue<BTNode> q = new LinkedList<BTNode>();
    q.add(temp);

    while (!q.isEmpty()) {
      temp = q.peek();
      q.remove();

      if (temp.left == null) {
        temp.left = new BTNode(key);
        break;
      } else q.add(temp.left);

      if (temp.right == null) {
        temp.right = new BTNode(key);
        break;
      } else q.add(temp.right);
    }
  }

  public static void main(String args[]) {
    root = new BTNode(10);
    root.left = new BTNode(11);
    root.left.left = new BTNode(7);
    root.right = new BTNode(9);
    root.right.left = new BTNode(15);
    root.right.right = new BTNode(8);

    System.out.print("Inorder traversal before insertion:");
    inorder(root);

    int key = 12;
    insert(root, key);

    System.out.print("\nInorder traversal after insertion:");
    inorder(root);
  }
}
