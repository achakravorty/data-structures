package LinkedList;

public class DLLDeletion {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    //GFG//
    //Given a doubly linked list and a position. The task is to delete
    //a node from given position in a doubly linked list.

    // Function returns the head of the doubly linkedlist after
    // deletion
    Node deleteNode(Node head, int x) {

        //if list is empty or position is negative
        if (head == null || x < 0) {
            return head;
        }

        //if you need to remove first element
        if (x == 1) {
            head = head.next;
            head.prev = null;
            return head;
        }

        Node pointer = head;

        //traverse list to find positon
        while (pointer != null && x > 1) {
            pointer = pointer.next;
            x--;
        }

        //if you have reached the end and the node does not exist
        if (pointer == null) {
            return head;
        }

        //change the next elements prev if not null
        if (pointer.next != null) {
            pointer.next.prev = pointer.prev;
        }

        //change prev elements next if not null
        if (pointer.prev != null) {
            pointer.prev.next = pointer.next;
        }

        return head;
    }

}
