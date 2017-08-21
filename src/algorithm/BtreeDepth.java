
package algorithm;

class Node {
  private Node left;
  private Node right;

  public int size() {
    return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
  }

}


public class BtreeDepth {

}
