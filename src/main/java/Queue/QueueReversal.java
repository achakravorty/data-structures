package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    //GFG//
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q) {

        Stack<Integer> temp_stack = new Stack<>();

        //dequeue and add to stack
        while (!q.isEmpty()) {
            temp_stack.add(q.poll());
        }

        //remove from stack and enqueue to queue
        while (!temp_stack.empty()) {
            q.add(temp_stack.pop());
        }

        return q;
    }
}
