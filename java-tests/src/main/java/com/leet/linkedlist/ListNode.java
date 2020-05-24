package com.leet.linkedlist;

public class ListNode {
  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

  ListNode(int x, ListNode node) {
    val = x;
    next = node;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    ListNode node = this;
    while (node != null) {
      sb.append(node.val).append(" ");
      node = node.next;
    }
    return sb.toString();
  }
}
