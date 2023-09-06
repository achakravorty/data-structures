package Arrays;

public class FirstNegativeIntegerInEveryWindowSizeK {

    //Sliding Window Problem

    //GFG//
    //Given an array A[] of size N and a positive integer K, find the
    //first negative integer for each and every window(contiguous
    //subarray) of size K.
    //If window does not contain a negatie integer, then return 0
    //for that window

    public long[] printFirstNegativeInteger(long[] A, int N, int K) {

        long[] result = new long[K];

//        int i = 0; //start of sliding window

        long first_neg = 0;

        for (int i = 0; i < K; i++) {
            if (first_neg == 0) {
                if (A[i] < 0) {
                    first_neg = A[i];
                }
            }

        }

        return result;
    }


}

/*
How to use Sliding Window Technique?

The general use of the Sliding window technique can be demonstrated
as follows:

    -Find the size of the window required
    -Compute the result for 1st window, i.e. from the start of the
    data structure
    -Then use a loop to slide the window by 1, and keep computing
    the result window by window.
 */
