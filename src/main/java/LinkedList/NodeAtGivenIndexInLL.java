package LinkedList;

public class NodeAtGivenIndexInLL {

    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    //Given a singly linked list with N nodes and a number X. The task
    //is to find the node at the given index (X)(1 based index) of
    //linked list.
    public static int getNth(Node node, int ind) {

        Node pointer = node;

        while (pointer != null && ind > 1) {
            ind--;
            pointer = pointer.next;
        }

        return pointer.data;

    }
}
