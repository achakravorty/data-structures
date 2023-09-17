package LinkedList;

public class DeleteNodeFromPositionSLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //GFG//
    //Given a singly linked list and an integer x. Delete xth node
    //from the singly linked list. Return the head of the list.

    Node deleteNode(Node head, int x) {

        if (x == 1) {
            head = head.next;
            return head;
        }

        Node pointer = head;
        Node before_p = head;

        while (pointer != null && x > 1) {
            before_p = pointer;
            pointer = pointer.next;
            x--;
        }


        before_p.next = pointer.next;

        return head;
    }


}
