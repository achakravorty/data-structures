package Tree;

import java.util.ArrayList;

public class InorderTraversalBinaryTree {

    class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    //GFG//
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {

        //WITH RECURSION//
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        if (root.left!=null) {
            list.addAll(inOrder(root.left));
        }
        list.add(root.data);
        if (root.right!=null) {
            list.addAll(inOrder(root.right));
        }

        return list;
    }
}
