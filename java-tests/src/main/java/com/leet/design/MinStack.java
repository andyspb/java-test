package com.leet.design;

class Elem {
  public int value;
  public int min;
  public Elem next;

  public Elem(int value, int min) {
    this.value = value;
    this.min = min;
  }

  public Elem(int value) {
    this.value = value;
  }
}

public class MinStack {
  public Elem top;

  public MinStack() {}

  public void push(int x) {
    if (top == null) {
      top = new Elem(x, x);
    } else {
      Elem e = new Elem(x, Math.min(x, top.min));
      e.next = top;
      top = e;
    }
  }

  public void pop() {
    if (top == null) return;
    Elem temp = top.next;
    top.next = null;
    top = temp;
  }

  public int top() {
    if (top == null) return -1;
    return top.value;
  }

  public int getMin() {
    if (top == null) return -1;
    return top.min;
  }

  public static void main(String[] args) {
    int x = 0;
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); //   --> Returns -3.
    minStack.pop();
    System.out.println(minStack.top()); //     --> Returns 0.
    System.out.println(minStack.getMin()); //   --> Returns -2.
  }
}
