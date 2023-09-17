package Arrays;

import static Arrays.ReverseArray.reverse;
import static Arrays.ReverseArray.reverseWord;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ReverseArrayTest {

    @Test
    public void testReverse() {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        int[] result = {5, 4, 3, 2, 1};
        assertArrayEquals(result, arr);
    }

    @Test
    public void testReverseWord() {
        String s = "Geeks";
        String result = reverseWord(s);
        assertTrue(result.equals("skeeG"));
    }

    @Test
    public void testReverseWord2() {
        String s = "hi";
        String result = reverseWord(s);
        assertTrue(result.equals("ih"));
    }
}