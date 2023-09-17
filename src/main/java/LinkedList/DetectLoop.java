package LinkedList;

public class DetectLoop {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {

        if (head == null) {
            return false;
        }

        //a list that does not have loop will have last node as null
        // Floyd’s Cycle-Finding Algorithm
        //use 2 pointers - fast and slow

        Node slow_pointer = head; //this will move by one
        Node fast_pointer = head; //this move by two

        while (fast_pointer != null && slow_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                return true; //loop has been detected
            }
        }

        return false;
    }

}
