package LinkedList;

public class DeleteNodeWithoutHeadPointerSLL {

    class Node {
        int data ;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    //GFG//
    //You are given a pointer/ reference to the node which is to be
    // deleted from the linked list of N nodes. The task is to delete
    // the node. Pointer/ reference to head node is not given.
    //Note: No head reference is given to you. It is guaranteed that
    // the node to be deleted is not a tail node in the linked list.

    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node del) {

        //hint ->VERY SIMPLE SOLUTION - since T(n) = O(1)//

        //just change the data of the current node
        del.data = del.next.data;
        del.next = del.next.next;
    }
}
