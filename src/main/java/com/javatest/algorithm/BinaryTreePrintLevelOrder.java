package com.javatest.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrintLevelOrder {

  public static void printLevelOrder(BiTreeNode head) {
    if (null == head) {
      return;
    }

    Queue<BiTreeNode> currentLevel = new LinkedList<>();
    Queue<BiTreeNode> nextLevel = new LinkedList<>();
    currentLevel.add(head);

    while (!currentLevel.isEmpty()) {
      Iterator<BiTreeNode> iter = currentLevel.iterator();
      while (iter.hasNext()) {
        BiTreeNode node = iter.next();
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
    BiTreeNode bt1 = new BiTreeNode(1);
    BiTreeNode bt2 = new BiTreeNode(2);
    BiTreeNode bt3 = new BiTreeNode(3);
    BiTreeNode bt4 = new BiTreeNode(4);
    BiTreeNode bt5 = new BiTreeNode(5);
    BiTreeNode bt6 = new BiTreeNode(6);
    BiTreeNode bt7 = new BiTreeNode(7);

    bt1.left = bt2;
    bt1.right = bt3;

    bt2.left = bt4;
    bt2.right = bt5;

    bt3.left = bt6;
    bt3.right = bt7;

    printLevelOrder(bt1);

  }

}


class BiTreeNode {
  public int value;
  public BiTreeNode left;
  public BiTreeNode right;

  public BiTreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

}
