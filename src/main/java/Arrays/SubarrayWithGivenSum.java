package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {

    //GFG//
    //Function to find a continuous sub-array which adds up to a given number.
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        //USING SLIDING WINDOW
        //have 2 pointers i, j
        //traverse left to right
        //add j to sum
        //if sum<s increase j
        //if sum == s, stop
        //if sum < s, increase i and reduce from sum
        //if no subarray found return array of -1


        int i = 0;
        int j = 0;
        int sum = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (j < n) {
            sum += arr[j];
//            System.out.println("i=" + i + " j=" + j + " sum=" + sum);
            while (i < j && sum > s) {  //when sum > s keep increasing i until it reaches j
                sum -= arr[i];
                i++;
            }
            if (sum == s) {
                result.add(i + 1);
                result.add(j + 1);
                return result;
            }

            j++;
        }

        result.add(-1); //when subarray not found
        return result;


        //WORKED BUT WRONG
//        int i = 0;
//        int j = 0;
//        int sum = 0;
//
//        ArrayList<Integer> result = new ArrayList<Integer>();
//
//        while (i < n && j < n) {
//            sum += arr[j];
//            System.out.println("i=" + i + " j=" + j + " sum=" + sum);
//            if (sum < s) {
//                j++;
//            } if (sum > s) {
//                sum -= arr[i];
//                i++;
//            } if (sum == s) {
//                result.add(i + 1);
//                result.add(j + 1);
//                return result;
//            }
//        }
//
//        result.add(-1);
//        return result;
    }

    public static void main(String[] args) {
        int[] arr = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        ArrayList<Integer> result = subarraySum(arr, 42, 5600); //(ArrayList) Arrays.asList("42, 468");
        System.out.println(result);
    }


}
