package Arrays;

public class MinMaxofArray {

    //GFG//
    //Given an array A of size N of integers.
    //Your task is to find the minimum and maximum elements in the array.
    static Pair getMinMax(long a[], long n) {
        long max = a[0];
        long min = a[0];

        for (int i=0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }

            if (a[i] > max) {
                max = a[i];
            }
        }

        Pair result = new Pair(min, max);
        return result;
    }

    //this is done in:
    //T(n) = O(n)
    //S(n) = O(1)

    public static void main(String[] args) {
        long[] arr = {1, 345, 234, 21, 56789};
        Pair res = getMinMax(arr,5);
    }
}

class Pair {
    long first, second;
    public Pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
