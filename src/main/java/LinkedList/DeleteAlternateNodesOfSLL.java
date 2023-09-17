package LinkedList;

public class DeleteAlternateNodesOfSLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //GFG//
    //Given a Singly Linked List of size N, delete all alternate nodes
    //of the list.
    public void deleteAlternate(Node head) {

        //only continue when there is more than one node
        if (head.next != null) {
            while (head != null) {
                if (head.next != null) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
        }
    }

}
