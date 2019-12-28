package com.leet.linkedlist;

class ListNode {
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
}

