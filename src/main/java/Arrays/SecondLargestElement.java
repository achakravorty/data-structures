package Arrays;

public class SecondLargestElement {

    //Given an array Arr of size N, print second
    //largest distinct element from an array.
    //Return -1 if second largest element does not
    //exist.
    public static int print2largest(int[] arr, int n) {

        //when array is empty or size is 1
        if (arr.length < 2) {
            return -1;
        }

        int max;
        int max2 = Integer.MIN_VALUE;

        //check element 0 and 1 first
        if (arr[0] > arr[1]) {
            max = arr[0];
            max2 = arr[1];
        } else {
            if (arr[1] > arr[0]) {
                max = arr[1];
                max2 = arr[0];
            } else {
                max = arr[0]; //this is when both elements are equal
            }
        }

        if (n > 2) {
            for (int i = 2; i < n; i++) {
                if (arr[i] == max) {
                    continue;
                } else {
                    if (arr[i] > max) {
                        max2 = max;  //update max2 when max changes
                        max = arr[i];
                    } else {
                        if (arr[i] > max2) {
                            max2 = arr[i];
                        }
                    }
                }
            }
        }

        //if no second largest found
        if (max2 == Integer.MIN_VALUE) {
            return -1;
        }

        return max2;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 2, 3, 14, 23, 1, 66, 7, 10};
        int result = print2largest(arr, 10);
        System.out.println(result);
    }
}
