package String;

public class PalindromeChecker {

    //Given a string S, check if it is palindrome or not.
    //Return 1 if yes and 0 if not.
    public static int isPalindrome(String S) {
        int n = S.length();

        for (int i = 0; i < n / 2; i++) {
            if (S.charAt(i) == S.charAt(n - i - 1)) {
                continue;
            } else {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String ex = "hello";
        System.out.println(ex.charAt(0));
    }
}
