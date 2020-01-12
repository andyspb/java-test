package com.leet.linkedlist;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = head;

    ListNode p1 = l1;
    ListNode p2 = l2;
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        p.next = p1;
        p1 = p1.next;
      } else {
        p.next = p2;
        p2 = p2.next;
      }
      p = p.next;
    }

    if (p1 != null) {
      p.next = p1;
    }

    if (p2 != null) {
      p.next = p2;
    }

    return head.next;
  }

  public static void main(String[] args) {
    MergeTwoSortedLists mt = new MergeTwoSortedLists();
    ListNode ln1 = new ListNode(1);
    ListNode ln2 = new ListNode(2);
    ListNode ln3 = new ListNode(3);
    ListNode ln4 = new ListNode(4);
    ln1.next = ln2;
    ln2.next = ln3;
    ln3.next = ln4;
    System.out.println(ln1.toString());

    ListNode ll1 = new ListNode(2);
    ListNode ll2 = new ListNode(3);
    ListNode ll3 = new ListNode(7);
    ListNode ll4 = new ListNode(8);
    ListNode ll5 = new ListNode(9);
    ListNode ll6 = new ListNode(10);
    ll1.next = ll2;
    ll2.next = ll3;
    ll3.next = ll4;
    ll4.next = ll5;
    ll5.next = ll6;
    System.out.println(ll1.toString());

    ListNode node = mt.mergeTwoLists(ln1, ll1);
    System.out.println(node.toString());
  }
}
