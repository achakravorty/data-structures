package Stack;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    //GFG//
    //Given a stack, delete the middle element of the stack without
    //using any additional data structure.
    //Middle element:- floor((size_of_stack+1)/2) (1-based indexing)
    //from bottom of the stack.
    //
    //Note: The output shown by the compiler is the stack from top to
    //bottom.

    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {

        double mid = Math.ceil((double) (sizeOfStack + 1) / 2);
        Stack<Integer> temp_s = new Stack<>();

        //remove until just before mid element and push to temp stack
        while (mid > 1) {
            temp_s.push(s.pop());
            mid--;
        }

        s.pop(); //deleting mid element

        //add back elements to stack
        while (!temp_s.isEmpty()) {
            s.push(temp_s.pop());
        }
    }
}
