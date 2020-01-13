package com.leet.design;

class Node<T> {
  public T value;
  public Node<T> next;

  public Node(T value) {
    this.value = value;
  }
}

public class Stack<T> {
  public Node<T> top;

  public void push(int x) {
    if (top == null) {
      top = new Node(x);
    } else {
      Node e = new Node(x);
      e.next = top;
      top = e;
    }
  }

  public T pop() {
    if (top == null) return null;
    T value = top.value;
    top = top.next;
    return value;
  }
}
