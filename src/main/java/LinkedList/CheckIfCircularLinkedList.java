package LinkedList;

public class CheckIfCircularLinkedList {

    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    // Given head, the head of a singly linked list,
    // find if the linked list is circular or not.
    // A linked list is called circular if it not
    // NULL terminated and all nodes are connected
    // in the form of a cycle. An empty linked list
    // is considered as circular.
    boolean isCircular(Node head) {

        if (head == null) {
            return true;
        } else {
            Node pointer = head;

            while (pointer.next != null) {
                if (pointer.next == head) {
                    return true;
                }
                pointer = pointer.next;
            }

            return false;
        }
    }
}
