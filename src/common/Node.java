package common;

public class Node {
  public Node(int value) {
    this.value = value;
  }
  
  public String toString() {
    return Integer.toString(value);
  }
  
  public int value;
  public Node next;
}
