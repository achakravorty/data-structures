package Arrays;

public class FindTheFrequency {

    //GFG//
    //Given a vector of N positive integers and an
    //integer X. The task is to find the frequency of X in vector.
    public int findFrequency(int A[], int x) {

        int count = 0;
        for (int i : A) {
            if (i == x) {
                count++;
            }
        }

        return count;
    }
}

