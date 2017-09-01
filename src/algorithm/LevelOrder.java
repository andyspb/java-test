package algorithm;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Given a binary tree, print the nodes out grouping by level a / \ b d c
 * 
 * a bd c
 */

public class LevelOrder {

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  // iterative method to do level order traversal line by line
  static void printLevelOrder(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> que = new LinkedList<Node>();
    que.add(root);

    while (true) {
      int nodeCount = que.size();
      if (nodeCount == 0) {
        break;
      }
      while (nodeCount > 0) {
        Node node = que.peek();
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
    //             1
    //          /     \
    //         2       3
    //       /   \       \
    //      4     5       6
      
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.right = new Node(6);
      
     printLevelOrder(root);
  }

}
