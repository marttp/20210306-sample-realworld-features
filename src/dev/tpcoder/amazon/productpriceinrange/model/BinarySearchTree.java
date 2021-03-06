package dev.tpcoder.amazon.productpriceinrange.model;

public class BinarySearchTree {

  private Node root;

  public Node getRoot() {
    return root;
  }

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(int val) {
    if (this.root == null) {
      this.root = new Node(val);
    } else {
      this.root.insert(val);
    }
  }
}
