package com.test.algorithm;

class ListNode {
  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  public ListNode next;
  public int val;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    ListNode node = this;
    while (node != null) {
      sb.append(val).append(" ");
      node = node.next;
    }
    return sb.toString();
  }
}
