package LinkedList;

public class InsertInMiddleOfLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //GFG//
    //Given a linked list of size N and a key. The task is to insert
    //the key in the middle of the linked list.

    public Node insertInMid(Node head, int data) {
        //Insert code here, return the head of modified linked list

        //if list is empty just add new node
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node newMid = new Node(data);

        //traverse list to find the size
        int size = 0;
        Node pointer = head;

        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }

        int mid = (size - 1) / 2;

        //traverse to get to mmind element
        Node currMid = head;

        while (currMid.next != null && mid > 0) {
            currMid = currMid.next;
            mid--;
        }

        //change new nodes next to mid elements next
        //change mid elements next to new node

        newMid.next = currMid.next;
        currMid.next = newMid;

        return head;
    }
}
