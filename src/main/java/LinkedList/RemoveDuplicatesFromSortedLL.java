package LinkedList;

public class RemoveDuplicatesFromSortedLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //GFG//
    //Given a singly linked list consisting of N nodes. The task is to
    //remove duplicates (nodes with duplicate values) from the given
    //list (if exists).
    //Note: Try not to use extra space. The nodes are arranged in a
    //sorted way.

    //Function to remove duplicates from sorted linked list and
    //return head of list.
    Node removeDuplicates(Node head) {

        //if there is only one node
        if (head.next == null) {
            return head;
        }

        Node pointer = head.next;
        Node before_p = head;

        //traverse list
        while (pointer != null) {
            //if data is equal of adjacent nodes then delete
            //second node, else move forward
            if (before_p.data == pointer.data) {
                before_p.next = pointer.next;
                pointer = before_p.next;
            } else {
                before_p = pointer;
                pointer = pointer.next;
            }
        }

        return head;
    }

}
