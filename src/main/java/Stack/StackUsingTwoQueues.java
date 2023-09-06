package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    //GFG//
    //Implement a Stack using two queues q1 and q2.

    class Queues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();


        //Function to push an element into stack using two queues.
        void push(int a) {
            q1.add(a);
        }

        //Function to pop an element from stack using two queues.
        int pop() {
            if (q1.isEmpty()) {
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int first = q1.remove();

            while (q2.size() > 0) {
                q1.add(q2.remove());
            }

            return first;
        }
    }
}
