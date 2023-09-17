package BinarySearchTree;

public class CheckforBST {

    //GFG//
    //Given the root of a binary tree. Check whether it is a BST or not.
    //Note: We are considering that BSTs can not contain duplicate Nodes.
    //A BST is defined as follows:
    //
    //    -The left subtree of a node contains only nodes with keys
    //    less than the node's key.
    //    -The right subtree of a node contains only nodes with keys
    //    greater than the node's key.
    //    -Both the left and right subtrees must also be binary
    //    search trees.


    //Function to check whether a Binary Tree is BST or not.
    public boolean isBST(Node root) {
        return bstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean bstHelper(Node node, int min, int max) {

        if (node == null) return true;

        if (node.data < min || node.data > max) {
            return false;
        }

        return bstHelper(node.left, min, node.data - 1) && bstHelper(node.right, node.data +1, max);
    }

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
