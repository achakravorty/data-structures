package LinkedList;

public class LinkedListInsertion {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;

        return head;
    }

    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        if (head == null) {
            return insertAtBeginning(head, x);
        } else {
            Node newNode = new Node(x);
            Node tail = head;

            while (tail.next != null) {
                tail = tail.next;
            }

            tail.next = newNode;

            return head;
        }
    }
}
