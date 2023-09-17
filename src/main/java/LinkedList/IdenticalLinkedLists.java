package LinkedList;

public class IdenticalLinkedLists {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //GFG//
    //Given two Singly Linked List of N and M nodes respectively. The
    //task is to check whether two linked lists are identical or not.
    //Two Linked Lists are identical when they have same data and with
    //same arrangement too.

    //Function to check whether two linked lists are identical or not.
    public boolean isIdentical(Node head1, Node head2) {

        //if both lists are empty
        if (head1 == null && head2 == null) {
            return true;
        }

        //if one of then is null and other is not (using XOR operator)
        if ((head1 == null) ^ (head2 == null)) {
            return false;
        }

        Node pointer1 = head1;
        Node pointer2 = head2;

        while (pointer1 != null && pointer2 != null) {
            //check if the elements are equal
            if (pointer1.data == pointer2.data) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            } else {
                return false;
            }
        }

        //checking is both pointers have reached the end at the
        //same time (if yes -true, else -fasle)
        return pointer1 == null && pointer2 == null;
    }
}
