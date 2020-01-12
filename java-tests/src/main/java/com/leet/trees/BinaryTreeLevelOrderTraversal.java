package com.leet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    LinkedList<Integer> levelQueue = new LinkedList<>();
    nodeQueue.offer(root);
    levelQueue.offer(1); // start from 1
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int level = levelQueue.poll();
      List<Integer> l = null;
      if (result.size() < level) {
        l = new ArrayList<>();
        result.add(l);
      } else {
        l = result.get(level - 1);
      }
      l.add(node.val);
      if (node.left != null) {
        nodeQueue.offer(node.left);
        levelQueue.offer(level + 1);
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        levelQueue.offer(level + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // {3,9,20,null,null,15,7}
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20);
    node1.left = node2;
    node1.right = node3;
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    node3.left = node4;
    node3.right = node5;
  }
}
