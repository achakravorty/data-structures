package Arrays;

public class MissingNumberInArray {

    //GFG//
    // Given an array of size N-1 such that it only
    // contains distinct integers in the range of 1
    // to N. Find the missing element.
    public static int missingNumber(int[] array, int n) {

        int total = n*(n+1)/2;
        int arrSum = 0;

        for (int i: array) {
            arrSum+=i;
        }

        return total - arrSum;
    }

    // another method is to use a kind of hashing
    // with one extra array
    // Idea: The numbers will be in the range (1, N),
    // an array of size N can be maintained to keep
    // record of the elements present in the given array
}
