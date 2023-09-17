package LinkedList;

public class CountNodesOfLinkedList {

    class Node{
        int data;
        Node next;
        Node(int a){  data = a; next = null; }
    }

    //Function to count nodes of a linked list.
    public static int getCount(Node head) {
        if (head == null) {
            return 0;
        } else {
            int count = 0;

            Node tail = head;

            while(tail.next != null) {
                count++;
                tail = tail.next;
            }
            return count;
        }
    }
}
