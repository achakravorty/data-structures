package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class LevelOrderTraversalBianrytree {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;

        }
    }

    //GFG//
    // Given a binary tree, find its level order traversal.
    // Level order traversal of a tree is breadth-first traversal
    // for the tree.

    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node node) {

        ArrayList<Integer> list = new ArrayList<>();

        if (node == null) return list;


        Deque<Node> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node p = q.remove();

            list.add(p.data);

            if (p.left != null) q.add(p.left);
            if (p.right != null) q.add(p.right);
        }

        return list;
    }
}
