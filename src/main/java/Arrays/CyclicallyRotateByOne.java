package Arrays;

public class CyclicallyRotateByOne {

    //GFG//
    //Given an array, rotate the array by
    //one position in clock-wise direction.
    public static void rotate(int[] arr, int n) {

        //by swapping from end
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, i - 1);
        }

        //by chaning elements one by one from end
//        int last = arr[n-1];
//        //traverse array
//        for (int i = n-1; i > 0; i--) {
//            arr[i] = arr[i-1];
//        }
//        arr[0] = last; // add last element to first position
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
