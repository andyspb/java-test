package com.test.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrintLevelOrder {

  public static void printLevelOrder(TreeNode head) {
    if (null == head) {
      return;
    }

    Queue<TreeNode> currentLevel = new LinkedList<>();
    Queue<TreeNode> nextLevel = new LinkedList<>();
    currentLevel.add(head);

    while (!currentLevel.isEmpty()) {
      Iterator<TreeNode> iter = currentLevel.iterator();
      while (iter.hasNext()) {
        TreeNode node = iter.next();
        if (null != node.left) {
          nextLevel.add(node.left);
        }
        if (null != node.right) {
          nextLevel.add(node.right);
        }
        System.out.print(node.value + " ");
      }
      System.out.println();
      currentLevel = nextLevel;
      nextLevel = new LinkedList<>();
    }
  }

  public static void main(String[] args) {
    TreeNode bt1 = new TreeNode(1);
    TreeNode bt2 = new TreeNode(2);
    TreeNode bt3 = new TreeNode(3);
    TreeNode bt4 = new TreeNode(4);
    TreeNode bt5 = new TreeNode(5);
    TreeNode bt6 = new TreeNode(6);
    TreeNode bt7 = new TreeNode(7);

    bt1.left = bt2;
    bt1.right = bt3;

    bt2.left = bt4;
    bt2.right = bt5;

    bt3.left = bt6;
    bt3.right = bt7;

    printLevelOrder(bt1);
  }
}

