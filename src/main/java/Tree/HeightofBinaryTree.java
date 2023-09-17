package Tree;

public class HeightofBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    //GFG//
    //Given a binary tree, find its height.

    //Function to find the height of a binary tree.
    public int height(Node node) {

        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Height of a node is the maximum of the heights of its left
        // and right subtrees + 1 (for the current node).
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*
        int h1 = 0;
        int h2 = 0;

        if (node.left!= null) {
            h1 = Math.max(h1, 1 + height(node.left));
        }
        if (node.right!=null) {
            h2 = Math.max(h2, 1 + height(node.right));
        }

        return Math.max(h1, h2);
     */
}
