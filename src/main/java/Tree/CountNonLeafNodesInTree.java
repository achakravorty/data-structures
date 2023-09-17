package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountNonLeafNodesInTree {

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //GFG//
    //Given a Binary Tree of size N, your task is to complete the
    //function countNonLeafNodes(), that should return the count of
    //all the non-leaf nodes of the given binary tree.

    //Function should return the count of total number of non leaf
    //nodes in the tree.
    public int countNonLeafNodes(Node root) {
        int count = 0;

        if (root == null) {
            return count;
        }

        //do any traversal - here we do BFS
        Deque<Node> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node p = q.remove();

            //checking if node is a non-leaf
            if (p.left != null || p.right != null) {
                count++;
            }

            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }

        return count;
    }

}
