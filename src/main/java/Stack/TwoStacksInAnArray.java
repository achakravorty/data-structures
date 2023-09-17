package Stack;

public class TwoStacksInAnArray {

    //GFG//
    //Your task is to implement  2 stacks in one array efficiently.
    //You need to implement 4 methods.
    //push1 : pushes element into first stack.
    //push2 : pushes element into second stack.
    //pop1 : pops element from first stack and returns the popped
    //element. If first stack is empty, it should return -1.
    //pop2 : pops element from second stack and returns the popped
    //element. If second stack is empty, it should return -1.
    //All methods should take O(1) Time complexity.
    //Note: The sum of count of elements in both the stacks < size of
    //the given array

    class twoStacks {
        int arr[];
        int size;
        int top1, top2;

        twoStacks() {
            size = 100;
            arr = new int[100];
            top1 = -1;
            top2 = size;
        }

        //Function to push an integer into the stack1.
        void push1(int x) {
            top1++;
            arr[top1] = x;
        }

        //Function to push an integer into the stack2.
        void push2(int x) {
            top2--;
            arr[top2] = x;
        }

        //Function to remove an element from top of the stack1.
        int pop1() {
            if (top1 == -1) {
                return -1;
            }
            int temp = arr[top1];
            arr[top1] = 0;
            top1--;

            return temp;
        }

        //Function to remove an element from top of the stack2.
        int pop2() {
            if (top2 == size) {
                return -1;
            }
            int temp = arr[top2];
            arr[top2] = 0;
            top2++;

            return temp;
        }
    }
}
