package Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PreorderTraversalBinaryTree {

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //Function to return a list containing the
    // preorder traversal of the binary tree.
    static ArrayList<Integer> preorder(Node root) {


        //WITH RECURSION//
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.data);
        if (root.left != null) {
            list.addAll(preorder(root.left));
        }
        if (root.right != null) {
            list.addAll(preorder(root.right));
        }

        return list;
    }
}
