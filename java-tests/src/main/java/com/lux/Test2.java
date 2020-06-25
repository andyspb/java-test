package com.lux;

interface Node {
  Object getValue();
  Node getNext();
}

public class Test2 {

  public static void loop(Node node) {
    Node h = node;
    int counter = 0;
    while(node.getNext() != null) {
      node  = node.getNext();
      ++counter;
    }
    
  }


}
