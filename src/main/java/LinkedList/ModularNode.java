package LinkedList;

public class ModularNode {

    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    //GFG//
    //Given a singly linked list and a number k, you are required to
    //complete the function modularNode() which returns the modular
    //node of the linked list.
    //A modular node is the last node of the linked list whose Index
    //is divisible by the number k, i.e. i%k==0.
    //Note: If no such node is available, return -1. We are following
    //1 indexing.

    // Your task is to complete the function should return the
    // modular Node.
    // If no such node is present then return -1.
    public static int moduarNode(Node head, int k) {

        //traverse list to find which indexes are divisible by k and
        //update the max index each time

        Node pointer = head;
        int i = 0;
        int max_index = 0;

        while (pointer != null) {
            i++;
            //if i is divisible by k then update max index
            if (i % k == 0) {
                max_index = i;
            }
            pointer = pointer.next;
        }

        //when node does not exist
        if (max_index == 0) {
            return -1;
        }

        //traverse again to find max_index element

        Node maxNode = head;

        while (max_index > 1) {
            maxNode = maxNode.next;
            max_index--;
        }

        return maxNode.data;
    }


}
