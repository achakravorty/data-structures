package Arrays;

import java.util.ArrayList;

public class FindDuplicates {

    //GFG
    // Given an array a of size N which contains
    // elements from 0 to N-1, you need to find
    // all the elements occurring more than once
    // in the given array. Return the answer in
    // ascending order. If no such element is
    // found, return list containing [-1].

    public static ArrayList<Integer> duplicates(int[] arr, int n) {

        //using extra space - hashing
        // brute force with extra array - add count of occurrences
        // to extra array

        ArrayList<Integer> list = new ArrayList<>();

        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            check[arr[i]]++;
        }

        for (int j = 0; j < n; j++) {
            if (check[j] > 1) {
                list.add(j);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}
