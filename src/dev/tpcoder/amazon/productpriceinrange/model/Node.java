package dev.tpcoder.amazon.productpriceinrange.model;

public class Node {

  private final int val;
  private Node leftChild;
  private Node rightChild;

  public int getVal() {
    return val;
  }

  public Node getLeftChild() {
    return leftChild;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public Node(int val) {
    this.val = val;
    this.leftChild = null;
    this.rightChild = null;
  }

  public void insert(int val) {
    Node current = this;
    Node parent = current;

    while (current != null) {
      parent = current;
      if (val < current.val) {
        current = current.leftChild;
      } else {
        current = current.rightChild;
      }
    }

    if (val < parent.val) {
      parent.leftChild = new Node(val);
    } else {
      parent.rightChild = new Node(val);
    }
  }
}
