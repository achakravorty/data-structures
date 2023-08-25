package Arrays;

import java.util.Arrays;

public class SortArrayof0s1s2s {

    //GFG//
    //Given an array of size N containing only 0s,
    //1s, and 2s; sort the array in ascending order.
    public static void sort012(int a[], int n) {

        int low = 0;
        int mid  = 0;
        int high = n-1;


        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, mid, low);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, high);
                    high--;
                    break;

            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0, 2};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
