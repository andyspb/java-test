package algorithm;

import java.util.HashSet;

class Node {
  int data;
  Node next;

  public Node(int d) {
    data = d;
    next = null;
  }
  public Node push(int value, Node prev) {
    Node node = new Node(value);
    prev.next = node;
    
    return node;
  }
}


public class DetectLoopInLinkedList {

  static boolean detectLoop(Node head) {
    Node slow_p = head, fast_p = head;
    while (slow_p != null && fast_p != null && fast_p.next != null) {
      slow_p = slow_p.next;
      fast_p = fast_p.next.next;
      if (slow_p == fast_p) {
        System.out.println("Found loop:" + fast_p.data);
        return true;
      }
    }
    return false;
  }
  
  public static void prinList(Node node) {
    Node n = node;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println("\n");
  }
  
  public static void main(String args[]) {
    System.out.println("DetectLoopInLinkedList main");
    
    // creat linked list
    Node head = new Node(10);

    Node list = head;
    
    list = list.push(11,list);
    list = list.push(12,list);
    
    
    list = list.push(13,list);
    Node loop = list;
    list = list.push(14,list);

   
    prinList(head);

    /* Create loop for testing */
    list.next = loop;

    boolean found = detectLoop(head);
    
    System.out.println("Loop found:" + found);
  }
}
