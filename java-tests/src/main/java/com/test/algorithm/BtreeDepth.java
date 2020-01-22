package com.test.algorithm;

public class BtreeDepth {
  class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    public int size() {
      return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
    }
  }
}
