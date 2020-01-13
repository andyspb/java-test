package com.leet.linkedlist;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
    return head;
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(1);
    ListNode ln2 = new ListNode(2);
    ListNode ln3 = new ListNode(3);
    ListNode ln4 = new ListNode(4);
    ln1.next = ln2;
    ln2.next = ln3;
    ln3.next = ln4;
    System.out.println(ln1);
    ReverseLinkedList rl = new ReverseLinkedList();
    ListNode node = rl.reverseList(ln1);
    System.out.println(node);
  }
}
