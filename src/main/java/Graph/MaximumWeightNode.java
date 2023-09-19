package Graph;

public class MaximumWeightNode {

    //GFG//
    // Given a maze with N cells. Each cell may have multiple entry
    // points but not more than one exit (i.e entry/exit points are
    // unidirectional doors like valves).
    // You are given an array Edge[] of N integers, where Edge[i]
    // contains the cell index that can be reached from cell i in one
    // step. Edge[i] is -1 if the ith cell doesn't have an exit.
    // The task is to find the cell with maximum weight (The weight
    // of a cell is the sum of cell indexes of all cells pointing
    // to that cell). If there are multiple cells with the maximum
    // weight return the cell with highest index.

    // Note: The cells are indexed with an integer value from 0 to
    // N-1. If there is no cell pointing to the ith cell then the
    // weight of the ith cell is zero.
    // If there are multiple answers then return the cell with
    // highest index.

    /**
     * Function to find node with maximum weight given a graph with
     * n nodes.
     * @param N integer denoting number of cells
     * @param Edge array of edges where Edge[i] contains cell index
     *             that can
     *            be reached from cell i in one step
     * @return the cell which has maximum weight
     */
    public static int maxWeightCell(int N, int[] Edge){
        //you need to keep count of each node's incoming total weight

        //array to store sum of weight of each node
        int[] weight_count = new int[N];

        //The weight of a cell is the sum of cell indexes of all
        //cells pointing to that cell
        for (int i =0; i < N; i++) {
            if (Edge[i]!=-1) {
                weight_count[Edge[i]]+=i;  //add the weight of the
                // edge
            }
        }

        int max = weight_count[0];
        int maxNode = 0;
        //traverse the new array to find max
        for (int i =0; i<N; i++) {
            if (weight_count[i] >= max) {
                max = weight_count[i];
                maxNode =i;
            }
        }
        return maxNode;
    }

    public static void main(String[] args) {
        int[] edge = {2,0,-1,2};
        System.out.println(maxWeightCell(4, edge));
    }
}
