package Arrays;

import java.util.Arrays;

public class SortTheArray {

    //GFG//
    //Given a random set of numbers, Print them in sorted order.
    public int[] sortArr(int[] arr, int n) {


        //merge sort - O(nlogn)

        //base case, if size is less than 2 then array is sorted
        if (n < 2) return arr;

        int mid = n / 2;

        //split into 2 arrays
        int[] left = Arrays.copyOfRange(arr, 0, mid); //first half
        int[] right = Arrays.copyOfRange(arr, mid, n); // second half

        left = sortArr(left, left.length);
        right = sortArr(right, right.length);


        int[] result = new int[n];
        int i = 0; //pointer for left subarray
        int j = 0; //pointer for right subarray
        int r = 0; //index of final result array

        //sorting by comparision and merging arrays
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[r] = left[i];
                r++;
                i++;
            } else {
                result[r] = right[j];
                r++;
                j++;
            }
        }

        //add remaining elements from both arrays
        while (i < left.length) {
            result[r] = left[i];
            r++;
            i++;
        }
        while (j < right.length) {
            result[r] = right[j];
            r++;
            j++;
        }

        return result;
    }

//    public void mergeSort(int arr, int start, int end) {
//    }
//
//    public void merge(int arr, int start, int mid, int end) {
//    }
}



//insertions sort - O(n^2)
//        int i;
//        int key;
//        int j;
//
//        for(i = 1; i < n; i++) {
//            key = arr[i];
//            j= i-1;
//            while(j >= 0 && arr[j] > key) {
//                arr[j+1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = key;
//        }


//selection sort - O(n^2)
//        for (int i = 0; i < n - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j] < arr[min])
//                    min = j;
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }