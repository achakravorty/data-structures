package LinkedList;

public class RemoveDuplicatesFromUnsortedLL {

    class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    //GFG//
    //Given an unsorted linked list of N nodes. The task is to remove
    // duplicate elements from this unsorted Linked List. When a value
    // appears in multiple nodes, the node which appeared first should
    // be kept, all others duplicates are to be removed.

    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {

        if (head.next == null) {
            return head;
        }

        //idea - use Hash Table to keep a count of elements and then later delete
        return head;
    }

}
