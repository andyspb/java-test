package com.test.algorithm;

import com.test.test.threads.Deadlock;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseLinkedList {
  private static final Logger log = Logger.getLogger(Deadlock.class.getName());

  public static void printList(ListNode ListNode) throws IOException {
    if (ListNode == null) {
      return;
    }

    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    while (ListNode != null) {
      log.write(ListNode.toString());
      log.write(' ');
      ListNode = ListNode.next;
    }
    log.write('\n');
    log.flush();
  }

  public static ListNode reverseListIter(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode prev = null;
    ListNode next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static ListNode reverseListRec(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode remaining = reverseListRec(head.next);

    System.out.println("head:" + head);
    System.out.println("remaining:" + remaining);

    head.next.next = head;

    System.out.println("head.next:" + head.next);

    head.next = null;
    return remaining;
  }

  public static void main(String[] args) throws IOException {
    log.log(Level.INFO, ">>>");
    ListNode n0 = new ListNode(0);
    ListNode n1 = new ListNode(1);
    n0.next = n1;
    ListNode n2 = new ListNode(2);
    n1.next = n2;
    ListNode n3 = new ListNode(3);
    n2.next = n3;
    ListNode n4 = new ListNode(4);
    n3.next = n4;

    printList(n0);
    n0 = reverseListIter(n0);
    printList(n0);
    printList(reverseListRec(n0));
  }
}
