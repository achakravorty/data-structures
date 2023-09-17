package Arrays;

import java.util.Arrays;

public class MoveAllNegElementsToEnd {

    //GFG//
    //Given an unsorted array arr[] of size N having
    //both negative and positive integers. The task
    //is place all negative element at the end of
    //array without changing the order of positive
    //element and negative element.

    public static void segregateElements(int[] arr, int n) {

        //use 2 diff loops

        //loop 1 - count number of negative numbers
        //create a new
        //have 2 pointers i for adding positive numbers and j for adding negative numbers to new array
        //loop 2 - traverse array and check if element is pos or neg

        int negCount = 0;

        for (int i : arr) {
            if (i < 0) negCount++;
        }

        int i = 0;
        int j = n - negCount;
        int[] newArr = new int[n];


        for (int k : arr) {
            if (k > 0) newArr[i++] = k;
            else newArr[j++] = k;
        }

        //copy result array into original array
        System.arraycopy(newArr, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements(arr, 8);
        System.out.println(Arrays.toString(arr));
    }
}
