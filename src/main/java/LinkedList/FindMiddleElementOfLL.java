package LinkedList;

public class FindMiddleElementOfLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //GFG//
    //Given a singly linked list of N nodes.
    //The task is to find the middle of the linked list. For example,
    // if the linked list is 1-> 2->3->4->5, then the middle node
    // of the list is 3. If there are two middle nodes(in case,
    // when N is even), print the second middle element.
    int getMiddle(Node head) {

        //traverse list to find the size of list
        Node pointer = head;
        int size = 0;

        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }

        int mid = size / 2;

        pointer = head;

        //traverse list to find mid element
        while (pointer.next != null && mid > 0) {
            pointer = pointer.next;
            mid--;
        }

        return pointer.data;
    }
}
