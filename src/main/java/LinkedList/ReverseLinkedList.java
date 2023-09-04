package LinkedList;

public class ReverseLinkedList {

    class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    //GFG//
    //Given a linked list of N nodes. The task is to reverse this
    //list.

    // Function to reverse a linked list, that returns head of
    // reversed list.
    Node reverseList(Node head) {
        //idea - keep 3 pointers, point, before_p & after_p
        //change the p.next to before_p and moe the pointers ahead
        //at the end change head to current p

        //if there is only one node
        if (head.next == null) {
            return head;
        }

        Node before_p = head;
        Node pointer = head.next;
        Node after_p = head;

        //traverse list to reverse nodes of list
        while (pointer != null) {
            after_p = pointer.next;
            pointer.next = before_p; //change nodes next to prev

            before_p = pointer;
            pointer = after_p;
        }

        //change head
        head.next = null;
        head = before_p;

        return head;
    }
}
