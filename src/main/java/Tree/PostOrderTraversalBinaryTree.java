package Tree;

import java.util.ArrayList;



public class PostOrderTraversalBinaryTree {

    //A Binary Tree node
    class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    //GFG//
    //Function to return a list containing the postorder traversal of the tree.
    public static ArrayList<Integer> postOrder(Node root) {

        //WITH RECURSION//
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        if (root.left!=null) {
            list.addAll(postOrder(root.left));
        }
        if (root.right!=null) {
            list.addAll(postOrder(root.right));
        }
        list.add(root.data);

        return list;
    }
}
