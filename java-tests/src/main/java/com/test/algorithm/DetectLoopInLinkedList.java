package com.test.algorithm;

class LListNode {
  int data;
  LListNode next;

  public LListNode(int d) {
    data = d;
    next = null;
  }

  public LListNode push(int value, LListNode prev) {
    LListNode LListNode = new LListNode(value);
    prev.next = LListNode;

    return LListNode;
  }
}

public class DetectLoopInLinkedList {

  static boolean detectLoop(LListNode head) {
    LListNode slow_p = head, fast_p = head;
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

  public static void prinList(LListNode LListNode) {
    LListNode n = LListNode;
    while (LListNode != null) {
      System.out.print(LListNode.data + " ");
      LListNode = LListNode.next;
    }
    System.out.println("\n");
  }

  public static void main(String args[]) {
    System.out.println("DetectLoopInLinkedList main");

    // creat linked list
    LListNode head = new LListNode(10);

    LListNode list = head;

    list = list.push(11, list);
    list = list.push(12, list);

    list = list.push(13, list);
    LListNode loop = list;
    list = list.push(14, list);

    prinList(head);

    /* Create loop for testing */
    list.next = loop;

    boolean found = detectLoop(head);

    System.out.println("Loop found:" + found);
  }
}
