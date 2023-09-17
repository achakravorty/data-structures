package Arrays;

public class PeakElement {

    //GFG//
    //An element is called a peak element if its value is not smaller
    // than the value of its adjacent elements(if they exists).
    //Given an array arr[] of size N, Return the index of any one of
    // its peak elements.
    public int peakElement(int[] arr, int n) {

        if (n > 1) {
            //if first element is greater than second
            //or last element is greater than second last then terminate

            if (arr[0] >= arr[1]) {
                return 0;
            }
            if (arr[n - 1] >= arr[n - 2]) {
                return n - 1;
            } else {
                for (int i = 1; i < n - 1; i++) {
                    if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                        return i;
                    }
                }
            }
        }

        return 0;
    }

    //this is done in:
    //T(n) = O(n)
    //S(n) = O(1)

    //to do this in time complexity O(logn), try to find peak element with binary search
}
