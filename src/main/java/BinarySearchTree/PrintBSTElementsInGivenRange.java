package BinarySearchTree;

import java.util.ArrayList;

public class PrintBSTElementsInGivenRange {

    //GFG//
    // Given a Binary Search Tree and a range [low, high]. Find all
    // the numbers in the BST that lie in the given range.
    // Note: Element greater than or equal to root go to the right
    // side.

    // Your task is to complete the function printNearNodes() which
    // takes the root Node of the BST and the range elements low and
    // high as inputs and returns an array that contains the BST
    // elements in the given range low to high (inclusive) in
    // non-decreasing order.

    //Function to return a list of BST elements in a given range.
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {

        ArrayList<Integer> list = new ArrayList<>();

        return list;

    }


    // A Binary Tree node
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
