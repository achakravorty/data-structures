package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SizeOfBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    //GFG//
    //Given a binary tree of size N, you have to count number of nodes
    //in it.

    public static int getSize(Node root) {

        if (root == null) {
            return 0;
        }

        int size = 0;
        Deque<Node> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node p = q.remove();

            size++;

            if (p.left!=null) {
                q.add(p.left);
            }
            if (p.right!=null) {
                q.add(p.right);
            }

        }

        return size;
    }
}
