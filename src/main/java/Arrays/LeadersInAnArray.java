package Arrays;

import java.util.*;

public class LeadersInAnArray {

    //GFG//
    // Given an array A of positive integers. Your
    // task is to find the leaders in the array.
    // An element of array is leader if it is
    // greater than or equal to all the elements
    // to its right side. The rightmost element
    // is always a leader.

    //Function to find the leaders in the array.
    public static ArrayList<Integer> leaders(int[] arr, int n) {

        //traverse from end - since we only need to check elemnts on the right
        //keep a max element
        //check if current element is greater than max
        //if yes then it is a leader and update max


        ArrayList<Integer> temp = new ArrayList<>();

        int max = arr[n - 1];
        temp.add(max);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {  //take care of duplicated with >=
                max = arr[i];
                temp.add(max);
            }
        }

        Collections.reverse(temp);

        return temp;

        //correct aproach but usage of linkedList causes problem with large inputs
//        LinkedList<Integer> temp = new LinkedList<>();
//        temp.add(arr[n - 1]);
//
//        int max = arr[n - 1];
//
//        for (int i = n - 2; i >= 0; i--) {
//            if (arr[i] > max) {
//                temp.addFirst(arr[i]);
//                max = arr[i];
//            }
//        }
//
//        return new ArrayList<Integer>(temp);
    }
}
