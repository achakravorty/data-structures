package Queue;

public class QueueUsingLLImp {

    class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    //GFG//
    //Implement a Queue using Linked List.

    class MyQueue {
        QueueNode front, rear;

        //Function to push an element into the queue.
        void push(int a) {
            //do addLast(a) function of linked list
            //since you are enqueing at the
            //Note: you have reference to tail
            QueueNode newNode = new QueueNode(a);

            if (front == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        //Function to pop front element from the queue.
        //Return -1 if Queue is empty.
        int pop() {
            //if Queue is empty
            if (front == null) {
                return -1;
            }

            //if there is only one elemnt
            if (front == rear) {
                QueueNode first = front;

                front = null;
                rear = null;

                return first.data;
            }

            QueueNode first = front;

            front = front.next;

            return first.data;
        }
    }

}
