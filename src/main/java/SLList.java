public class SLList {

    class Node {

        // Each node object has these two fields
        private Object element;

        private Node next;

        /**
         * Creates a Node object with element = e and next = n
         * @param e Element for the node.
         * @param n Next node.
         */
        Node(Object e, Node n) {
            element = e;
            next = n;
        }

        /**
         * Sets the element to the given parameter.
         * @param e The new element for this node.
         */
        public void setElement(Object e) {
            element = e;
        }

        /**
         * Returns the element of this node.
         * @return The element of this node.
         */
        public Object getElement() {
            return element;
        }

        /**
         * Sets the next pointer to the given node.
         * @param n Node to make next point to.
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Returns the next node.
         * @return The next node.
         */
        public Node getNext() {
            return next;
        }
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    /**
     * @return The element in the head Node of the SLL
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        head = new Node(e, head);
    }

    /**
     * Removes the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {

        if (head == null) {
            return null;
        }

        Node first = head;

        head = head.getNext();

        return first.getElement();
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {

        if (head == null) {
            addFirst(e);
            return;
        }
        Node newNode = new Node(e, null);

        //traverse list to find tail
         Node tail = head;
         while(tail.getNext()!=null) {
             tail = tail.getNext();
         }

         tail.setNext(newNode);
    }

    /**
     * Removes the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return removeFirst();
        }

        //traverse list to find tail
        Node tail = head;
        Node beforeTail = head;

        while(tail.getNext()!=null) {
            beforeTail = tail;
            tail = tail.getNext();
        }

        beforeTail.setNext(null);

        return tail.getElement();

    }

    /**
     * Removes Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {

        if (head == null) {
            return null;
        }
        if (pos < 0) {
            return null;
        }
        if (pos == 0) {
            return removeFirst();
        }

        int size = 1;
        //traverse list to find its size
        Node tail = head;
        while(tail.getNext()!=null) {
            size++;
            tail = tail.getNext();
        }

        if (pos>size-1) {
            return null;
        }

        if (pos == size-1) {
            return removeLast();
        }

        Node finger = head;
        Node beforeFinger = head;
        //traverse to find node at postion
        while(pos>0) {
            beforeFinger = finger;
            finger=finger.getNext();
            pos--;
        }

        beforeFinger.setNext(finger.getNext()); //removing node
        return finger.getElement();
    }

    //ANOTHER POSSIBLE ANSWER
//         public Object removeFromPosition(int pos) {
//         if (pos < 0) {
//             return null;
//         }
//         if (pos == 0) {
//             return removeFirst();
//         }
//
//         Node pointer = head;
//         Node prev = head;
//
//         while (pointer!=null && pos > 0) {
//             prev = pointer;
//             pointer = pointer.getNext();
//             pos--;
//         }
//
//         if (pointer == null) {
//             return null;
//         }
//
//         prev.setNext(pointer.getNext());
//
//         return pointer.getElement();
//     }
// }
}
