package LinkedList;

public class NthNodefromEndOfLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n) {

        // idea - get the size of the list and then traverse the
        // difference of index and size to get the nth node

        if (n <= 0 || head == null) {
            return -1;
        }

        Node pointer = head;
        int size = 0;

        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }

        if (n > size) {
            return -1;
        }

        int index = size - n;

        //traverse list to find nth node from end
        Node nthNode = head;

        while (nthNode != null && index > 0) {
            nthNode = nthNode.next;
            index--;
        }

        return nthNode.data;
    }
}
