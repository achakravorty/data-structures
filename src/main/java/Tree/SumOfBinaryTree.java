package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfBinaryTree {

    class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    //GFG//
    //Given a Binary Tree of size N, your task is to complete the
    //function sumBt(), that should return the sum of all the nodes
    //of the given binary tree.

    public static int sumBT(Node head){
        int sum = 0;

        if (head == null) {
            return sum;
        }

        //do any traversal - here we do BFS
        Deque<Node> q = new ArrayDeque<>();

        q.add(head);

        while (!q.isEmpty()) {
            Node p = q.remove();

            //add node to sum
            sum += p.data;


            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }

        return sum;
    }
}
