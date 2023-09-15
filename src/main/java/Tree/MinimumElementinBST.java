package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumElementinBST {

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
    //Given a Binary Search Tree. The task is to find the minimum
    //valued element in this given BST.

    //Function to find the minimum element in the given BST.
    public int minValue(Node node) {

        if (node == null) {
            return -1;
        }

        int min = node.data;

        //do any traversal - here we do BFS
        Deque<Node> q = new ArrayDeque<>();

        q.add(node);

        while (!q.isEmpty()) {
            Node p = q.remove();

            if (p.data < min) {
                min = p.data;
            }

            //only go to the left since its BST
            if (p.left != null) {
                q.add(p.left);
            }

        }

        return min;
    }
}
