package Arrays;


import static Arrays.MissingNumberInArray.missingNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberInArrayTest {

    @Test
    void testMissingNumber() {
        int[] arr= {1,2,3,5};
        int result =  missingNumber(arr,5);
        assertEquals(4,result);
    }

}