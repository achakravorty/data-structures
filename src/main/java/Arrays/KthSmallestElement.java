package Arrays;

import java.util.Arrays;

public class KthSmallestElement {

    //GFG//
    //Given an array arr[] and an integer K where K is
    //smaller than size of array, the task is to find
    //the Kth smallest element in the given array. It
    //is given that all array elements are distinct.
    //
    //Note :-  l and r denotes the starting and ending
    //index of the array.
    public static int kthSmallest(int[] arr, int l, int r, int k) {

        Arrays.sort(arr);
        return arr[k-1];
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(arr[arr.length-1]);
        int result = kthSmallest(arr, 0, 5, 3);

    }
}
