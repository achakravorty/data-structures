package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class CountLeavesinBinaryTree {

    class Node {
        int data;
        Node left, right;
    }

    //GFG//
    //Given a Binary Tree of size N, You have to count leaves in it.

    int countLeaves(Node node) {

        int count = 0;

        if (node == null) {
            return count;
        }

        //do any traversal - here we do BFS
        Deque<Node> q = new ArrayDeque<>();

        q.add(node);

        while (!q.isEmpty()) {
            Node p = q.remove();

            //checking if node is a leaf
            if (p.left == null && p.right == null) {
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
