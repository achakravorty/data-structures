package Arrays;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowSizeK {

    //Sliding Window Problem

    //GFG//
    //Given an array A[] of size N and a positive integer K, find the
    //first negative integer for each and every window(contiguous
    //subarray) of size K.
    //If window does not contain a negative integer, then return 0
    //for that window

    public long[] printFirstNegativeInteger(long[] A, int N, int K) {
        Deque<Integer> dq = new ArrayDeque<>(); //to keep track of negative element indices
        long[] result = new long[N - K + 1];
        int resultIndex = 0;

        for (int i = 0; i < N; i++) {
            //checking if ou are within the window size
            while (!dq.isEmpty() && dq.peek() <= i - K) {
                dq.remove();
            }

            //add negative elements to queue
            if (A[i] < 0) {
                dq.add(i);
            }

            if (i >= K - 1) {
                if (!dq.isEmpty()) {
                    result[resultIndex] = A[dq.peek()];
                } else {
                    result[resultIndex] = 0;
                }
                resultIndex++;
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


/*
        //SOLUTION 2//
        //Queue to keep indices of negative elements
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Long> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (j < N) {
            if (A[j] < 0) {
                queue.add(j);
            }

            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (!queue.isEmpty()) {
                    result.add(A[queue.peek()]);
                } else {
                    result.add((long) 0);
                }

                if (!queue.isEmpty() && queue.peek() == i) {
                    queue.poll();
                }

                i++;
                j++;
            }
        }

        long[] r = new long[result.size()];

        for (int k = 0; k < result.size(); k++) {
            r[k] = result.get(k);
        }

        return r;
*/