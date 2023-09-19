package Map;

import java.util.HashMap;
import java.util.Map;

public class SumOfFunctionOverAllPairsInAnArray {

    //GFG//
    //Sum of f(a[i], a[j]) over all pairs in an array of n integers

    //Given an array A of n integers, find the sum of f(a[i], a[j])
    //of all pairs (i, j) such that (1 <= i < j <= n).

    /*
    f(a[i], a[j]):   if abs(a[j]-a[i]) > 1

                     f(a[i], a[j]) = a[j] - a[i]

                     else  if abs(a[j]-a[i]) <= 1

                     f(a[i], a[j]) = 0
     */

    //Expected Time Complexity: O(N)
    //Expected Auxiliary Space: O(N)

    /**
     * Function for calculating sum of f(a[i], a[j]) over all pairs
     * in an array.
     *
     * @param arr given array
     * @param n   size of given array
     * @return return an integer denoting the sum of f(a[i], a[j])
     * of all pairs
     */
    public static long sum(int[] arr, int n) {
        // Map to keep a count of occurrences
        Map<Long, Long> count = new HashMap<>();

        long ans = 0;
        long pre_sum = 0;

        // Traverse in the list from start to end
        // number of times a[i] can be in a pair and
        // to get the difference we subtract pre_sum
        for (int i = 0; i < n; i++) {
            ans += (i * (long) arr[i]) - pre_sum;
            pre_sum += arr[i];

            // If the (a[i]-1) is present then subtract
            // that value as f(a[i], a[i]-1) = 0
            if (count.containsKey((long) arr[i] - 1)) {
                ans -= count.get((long) arr[i] - 1);
            }

            // If the (a[i]+1) is present then
            // add that value as f(a[i], a[i]-1)=0
            // here we add as a[i]-(a[i]-1)<0 which would
            // have been added as negative sum, so we add
            // to remove this pair from the sum value
            if (count.containsKey((long) arr[i] + 1)) {
                ans += count.get((long) arr[i] + 1);
            }

            // keeping a counter for every element
            if (count.containsKey((long) arr[i])) {
                count.put((long) arr[i],
                        count.get((long) arr[i]) + 1);
            } else {
                count.put((long) arr[i], (long) 1);
            }
        }
        return ans;
    }

    /*
    //BRUTE FORCE METHOD - Time O(n^2)//
    //use 2 for loops and update sum when necessary
    public static long sum (int arr[], int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int pair_diff = f(arr[i], arr[j]);
                sum+=pair_diff;
            }
        }

        return sum;
    }

    public static int f(int i, int j) {
        int pair_diff = Math.abs(i - j);

        if (pair_diff > 1) {
            return j - i;
        } else {
            return 0;
        }
    }
     */


}
