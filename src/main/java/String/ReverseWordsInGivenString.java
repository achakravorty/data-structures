package String;

import java.util.Arrays;

public class ReverseWordsInGivenString {

    //Function to reverse words in a given string.
    //without reversing the individual words
    public static String reverseWords(String S) {

        String[] words = S.split("\\.");
//        System.out.println(Arrays.toString(words));
        int n = words.length;

        for (int i = 0; i < n / 2; i++) {
            String temp = words[i];
            words[i] = words[n - i - 1];
            words[n - i - 1] = temp;
        }
//        System.out.println(Arrays.toString(words));

        //add back thw words to original string
        S = "";
        for (int i = 0; i < n-1; i++) {
            S = S + words[i] + ".";
        }

        S = S + words[n-1];

        return S;
    }

    public static void main(String[] args) {
        String S = "i.like.this";
        System.out.println(reverseWords(S));
    }
}
