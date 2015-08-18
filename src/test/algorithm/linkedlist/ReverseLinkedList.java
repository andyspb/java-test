package test.algorithm.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.Node;
import test.threads.Deadlock;

public class ReverseLinkedList {
  private static final Logger log = Logger.getLogger(Deadlock.class.getName());

  public static void printList(Node node) throws IOException {
    if (node == null) {
      return;
    }

    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    while (node != null) {
      log.write(node.toString());
      log.write(' ');
      node = node.next;
    }
    log.write('\n');
    log.flush();
  }

  public static Node reverseListIter(Node head) {
    if (head == null || head.next == null) return head;

    Node prev = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;

  }

  public static Node reverseListRec(Node head) {
    if (head == null || head.next == null) return head;

    Node remaining = reverseListRec(head.next);  
    
    System.out.println("head:" + head);
    System.out.println("remaining:" + remaining);
    
    head.next.next = head;
    
    System.out.println("head.next:" + head.next);
    
    head.next = null;
    return remaining;

  }


  public static void main(String[] args) throws IOException {
    log.log(Level.INFO, ">>>");
    Node n0 = new Node(0);
    Node n1 = new Node(1);
    n0.next = n1;
    Node n2 = new Node(2);
    n1.next = n2;
    Node n3 = new Node(3);
    n2.next = n3;
    Node n4 = new Node(4);
    n3.next = n4;

    printList(n0);
    n0 = reverseListIter(n0);
    printList(n0);
    printList(reverseListRec(n0));

    
  }

}
