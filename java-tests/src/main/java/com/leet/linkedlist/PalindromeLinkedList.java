package com.leet.linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
  ListNode left;

  public boolean isPalindrome(ListNode head) {
    ListNode node = head;
    Stack<Integer> stack = new Stack<Integer>();
    while (node != null) {
      stack.push(node.val);
      node = node.next;
    }
    while (head != null) {
      int val = stack.pop();
      if (head.val != val) {
        return false;
      }
      head = head.next;
    }
    return true;
  }

  public static void main(String[] args) {
    //
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(3);
    ListNode node6 = new ListNode(2);
    ListNode node7 = new ListNode(1);

    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    PalindromeLinkedList pll = new PalindromeLinkedList();
    boolean isPalindrome = pll.isPalindrome(head);
    System.out.println(isPalindrome);
  }
}
