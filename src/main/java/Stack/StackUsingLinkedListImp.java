package Stack;

public class StackUsingLinkedListImp {


    class MyStack {
         class StackNode {
             int data;
             StackNode next;
             StackNode(int a) {
                 data = a;
                 next = null;
             }
         }

        StackNode top;

        //Function to push an integer into the stack.
        void push(int a) {

            StackNode newNode = new StackNode(a);
            newNode.next = top;
            top = newNode;
        }

        //Function to remove an item from top of the stack.
        int pop() {

            //return -1 is stack is empty
            if (top == null) {
                return -1;
            }

            StackNode temp = top;
            top = top.next;

            return temp.data;
        }
    }

}
