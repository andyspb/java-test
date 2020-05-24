package com.test.algorithm;

class BTreeNode {
  int key;
  BTreeNode left, right;

  public BTreeNode(int key) {
    this.key = key;
    left = right = null;
  }
}

class Distance {
  int minDis = Integer.MAX_VALUE;
}

public class BinaryTreeClosetLeaf {
  BTreeNode root;

  public static void main(String[] args) {
    BinaryTreeClosetLeaf tree = new BinaryTreeClosetLeaf();

    // Let us create Binary Tree shown in above example
    tree.root = new BTreeNode(1);
    tree.root.left = new BTreeNode(12);
    tree.root.right = new BTreeNode(13);

    tree.root.right.left = new BTreeNode(14);
    tree.root.right.right = new BTreeNode(15);

    tree.root.right.left.left = new BTreeNode(21);
    tree.root.right.left.right = new BTreeNode(22);
    tree.root.right.right.left = new BTreeNode(23);
    tree.root.right.right.right = new BTreeNode(24);

    tree.root.right.left.left.left = new BTreeNode(1);
    tree.root.right.left.left.right = new BTreeNode(2);
    tree.root.right.left.right.left = new BTreeNode(3);
    tree.root.right.left.right.right = new BTreeNode(4);
    tree.root.right.right.left.left = new BTreeNode(5);
    tree.root.right.right.left.right = new BTreeNode(6);
    tree.root.right.right.right.left = new BTreeNode(7);
    tree.root.right.right.right.right = new BTreeNode(8);

    BTreeNode x = tree.root.right;

    System.out.println(
        "The closest leaf to node with value "
            + x.key
            + " is at a distance of "
            + tree.minimumDistance(tree.root, x));
  }

  void findLeafDown(BTreeNode root, int lev, Distance minDist) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      if (lev < (minDist.minDis)) minDist.minDis = lev;
      return;
    }
    findLeafDown(root.left, lev + 1, minDist);
    findLeafDown(root.right, lev + 1, minDist);
  }

  int findThroughParent(BTreeNode root, BTreeNode x, Distance minDist) {
    if (root == null) return -1;
    if (root == x) return 0;

    int l = findThroughParent(root.left, x, minDist);

    if (l != -1) {
      findLeafDown(root.right, l + 2, minDist);
      return l + 1;
    }

    int r = findThroughParent(root.right, x, minDist);
    if (r != -1) {
      findLeafDown(root.left, r + 2, minDist);
      return r + 1;
    }

    return -1;
  }

  int minimumDistance(BTreeNode root, BTreeNode x) {
    Distance d = new Distance();
    findLeafDown(x, 0, d);
    findThroughParent(root, x, d);
    return d.minDis;
  }
}
