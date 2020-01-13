package com.leet.linkedlist;

public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i <= n; ++i) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    RemoveNthNodeFromEndOfList rn = new RemoveNthNodeFromEndOfList();
    ListNode ll1 = new ListNode(1);
    ListNode ll2 = new ListNode(2);
    ListNode ll3 = new ListNode(3);
    ListNode ll4 = new ListNode(4);
    ListNode ll5 = new ListNode(5);
    ll1.next = ll2;
    ll2.next = ll3;
    ll3.next = ll4;
    ll4.next = ll5;
    System.out.println(ll1);
    rn.removeNthFromEnd(ll1, 2);
    System.out.println(ll1);
  }
}
