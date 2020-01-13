package com.leet.linkedlist;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    if (head.next == head) return true;
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && slow.next != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
        if (slow == fast) {
          return true;
        }
      }
      ;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode ll1 = new ListNode(2);
    ListNode ll2 = new ListNode(3);
    ListNode ll3 = new ListNode(7);
    ListNode ll4 = new ListNode(8);
    ListNode ll5 = new ListNode(9);
    ListNode ll6 = new ListNode(10);
    ll1.next = ll2;
    ll2.next = ll3;
    ll3.next = ll4;
    ll4.next = ll2;
    ll5.next = ll3;
    LinkedListCycle llc = new LinkedListCycle();
    boolean res = llc.hasCycle(ll1);
    System.out.println(res);
  }
}
