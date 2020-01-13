package com.leet.linkedlist;

public class RemoveNodeFromLinkedList {
  public void deleteNode(ListNode node) {
    if (node == null) return;
    // (except the tail
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static void main(String[] args) {
    RemoveNodeFromLinkedList rm = new RemoveNodeFromLinkedList();
    ListNode ll1 = new ListNode(4);
    ListNode ll2 = new ListNode(5);
    ListNode ll3 = new ListNode(1);
    ListNode ll4 = new ListNode(9);
    ll1.next = ll2;
    ll2.next = ll3;
    ll3.next = ll4;

    System.out.println(ll1);
    rm.deleteNode(ll2);
    System.out.println(ll1);
  }
}
