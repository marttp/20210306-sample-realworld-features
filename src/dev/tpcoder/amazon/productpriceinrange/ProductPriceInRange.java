package dev.tpcoder.amazon.productpriceinrange;

import dev.tpcoder.amazon.productpriceinrange.model.BinarySearchTree;
import dev.tpcoder.amazon.productpriceinrange.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPriceInRange {

  public static void main(String[] args) {
    // Driver code
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(9);
    bst.insert(6);
    bst.insert(14);
    bst.insert(20);
    bst.insert(1);
    bst.insert(30);
    bst.insert(8);
    bst.insert(17);
    bst.insert(5);

//    System.out.println(productsInRange(bst.getRoot(), 7, 20));
    System.out.println(
        productsInRange(bst.getRoot(), 7, 20)
            .stream()
            .sorted()
            .collect(Collectors.toList())
    );
  }

  public static List<Integer> productsInRange(Node root, int low, int high) {
    List<Integer> output = new ArrayList<>();
    preOrder(root, low, high, output);
    return output;
  }


  public static void preOrder(Node node, int low, int high, List<Integer> output) {
    if (node != null) {
      // In range then add
      if (node.getVal() <= high && low <= node.getVal()) {
        output.add(node.getVal());
      }

      // After add or not => go left child
      if (low <= node.getVal()) {
        preOrder(node.getLeftChild(), low, high, output);
      }

      // After add or not => go right child
      if (node.getVal() <= high) {
        preOrder(node.getRightChild(), low, high, output);
      }
    }
  }


}
