package Arrays;

public class EquilibriumPoint {

    //GFG//
    //Given an array A of n positive numbers. The
    //task is to find the first equilibrium point
    //in an array. Equilibrium point in an array is
    //a position such that the sum of elements
    //before it is equal to the sum of elements
    //after it.

    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long[] arr, int n) {

        // to do in O(n)
        // traverse array to get total sum
        // keep leftSum as 0 and
        // traverse array
        // rightSum = totalSUm - leftSum -
        // currentElem
        // if leftSum == rightSum then return
        // and each time add currentElem to
        // leftSum

        if (n == 1 ) { return 1; }

        long sum = 0;
        for (long i : arr) {
            sum += i;
        }

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            long rightSum = sum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }

        return -1;
    }
    //brute fore method - traverse array,
    // and then have 2 loops inside to find
    // leftSUm and rightSum

    public static void main(String[] args) {
        long[] arr = {1, 0};
        System.out.println(equilibriumPoint(arr, 2));
    }
}
