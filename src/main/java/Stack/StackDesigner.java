package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackDesigner {

    //GFG//
    //You are given an array arr of size N. You need to push the
    //elements of the array into a stack and then print them while
    //popping.

    public static Stack<Integer> _push(ArrayList<Integer> arr, int n) {

        Stack<Integer> stack = new Stack<>();
        for (int e : arr) {
            stack.push(e);
        }

        return stack;

    }

    public static void _pop(Stack<Integer> s) {

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
