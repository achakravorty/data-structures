package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LeftViewOfBinaryTree {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //GFG//
    //Given a Binary Tree, return Left view of it. Left view of a
    //Binary Tree is set of nodes visible when tree is visited from
    //Left side. The task is to complete the function leftView(),
    //which accepts root of the tree as argument.


    //Function to return list containing elements of left view of
    //binary tree.
    ArrayList<Integer> leftView(Node root) {

        //RECURSIVE SOLUTION
        // IDEA: do Preorder traversal & maintain maximum level
        // visited till the current node.  If the current level is
        // more than the maximum level visited till now, then the
        // current node is the first node of the current level, and
        // we print it and max_level will be changed to the current
        // level.
        ArrayList<Integer> list = new ArrayList<>();
        leftViewUtil(list, root, 1);

        return list;
    }

    int max_level = 0;

    //Recursive function to get left view of binary tree
    public void leftViewUtil(ArrayList<Integer> result, Node node, int level) {

        //if root is null, we simply return.
        if (node == null) return;

        //if this is the first node of its level then it is in the left view.
        if (max_level < level) {
            //storing data of current node in list.
            result.add(node.data);
            max_level = level;
        }

        //calling function recursively for left and right
        //subtrees of current node.
        leftViewUtil(result, node.left, level + 1);
        leftViewUtil(result, node.right, level + 1);


    }


    /*
    //BRUTE FORCE SOLUTION//
    // IDEA: do BFS and keep the track of the first node
        // encountered at each level. This will be the leftmost nde
        // at the level
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        //do any traversal - here we do BFS
        Deque<Node> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            //this for loop is used to process al nodes at the
            // current level of tree
            for (int i = 1; i < size; i++) {
                Node p = q.remove();

                //if it is the first node in the level then add to
                //list - which is leftmost node
                if (i == 1) {
                    list.add(p.data);
                }

                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
        }
        return list;
     */
}
