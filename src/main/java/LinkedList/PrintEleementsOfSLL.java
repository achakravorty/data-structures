package LinkedList;

public class PrintEleementsOfSLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Print elements of a linked list on console
    // head pointer input could be NULL as well
    // for empty list
    void display(Node head) {

        if (head == null) {
            return;
        }
        Node pointer = head;

        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }

    }
}
