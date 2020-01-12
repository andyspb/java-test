package com.leet.trees;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    } else if (r == null || l == null) {
      return false;
    }

    if (l.val != r.val) return false;

    if (!isSymmetric(l.left, r.right)) return false;
    if (!isSymmetric(l.right, r.left)) return false;

    return true;
  }

  public static void main(String[] args) {
    // {1,2,2,3,4,4,3}  true
    // {1,2,2,null,3,null,3} false
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(2);
    root.left = node2;
    root.right = node3;
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(3);
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;

    SymmetricTree st = new SymmetricTree();
    boolean isSymmetric = st.isSymmetric(root);
    System.out.println(isSymmetric);
  }
}
