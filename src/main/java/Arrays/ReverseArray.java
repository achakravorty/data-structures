package Arrays;

import java.util.Arrays;

public class ReverseArray {

    /**
     * Reverses the order of the elements of the given array in-place.
     *
     * @param arr the array to reverse
     */
    public static void reverse(int[] arr) {

        if (arr == null) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    //this is done in, where n is length of array:
    // T(n) = O(n)
    // S(n) = O(1)



    //GFG//
    /**
     * You are given a string s. You need to reverse the string.
     *
     * @param str input String
     * @return reveresed String
     */
    public static String reverseWord(String str) {
        char[] arr = str.toCharArray();

        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        String result = new String(arr);
        return result;
    }

    //this is done in:
    //T(n) = O(|S|)
    //S(n) = O(1)
}