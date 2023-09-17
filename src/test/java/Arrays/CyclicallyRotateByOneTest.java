package Arrays;

import static Arrays.CyclicallyRotateByOne.rotate;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class CyclicallyRotateByOneTest {

    @Test
    void testRotate() {
        int[] arr = {1,2,3,4,5};
        rotate(arr,5);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(new int[]{5,1,2,3,4}, arr);

    }
}