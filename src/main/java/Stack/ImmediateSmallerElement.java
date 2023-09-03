package Stack;

public class ImmediateSmallerElement {

    // Given an integer array Arr of size N. For
    // each element in the array, check whether
    // the right adjacent element (on the next
    // immediate position) of the array is smaller.
    // If next element is smaller, update the
    // current index to that element. If not, then
    // -1.
    public static void immediateSmaller(int[] arr, int n) {

        //you do not need to print anything but change the array
        //itself

        for (int i = 0; i < n - 1; i++) {
            // System.out.println(arr[i] + " & " + arr[i++]);
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i+1];
            } else {
                arr[i] = -1;
            }
        }

        arr[n-1] = -1;

        //this is if you had to only print
//        for (int i = 0; i < n - 1; i++) {
//            //System.out.println(arr[i] + " & " + arr[i++]);
//            if (arr[i] > arr[i + 1]) {
//                System.out.print(arr[i + 1] + " ");
//            } else {
//                System.out.print(-1 + " ");
//            }
//        }
//
//        System.out.print(-1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        immediateSmaller(arr, 5);
    }
}
